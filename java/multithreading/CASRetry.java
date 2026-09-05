package multithreading;

import java.util.concurrent.atomic.AtomicReference;

import static java.lang.Thread.sleep;

public class CASRetry {

    static void main() throws InterruptedException {
        LikeCounter likeCounter = new LikeCounter();
        Thread t1 = new Thread(() -> likeCounter.like());
        Thread t2 = new Thread(() -> likeCounter.like());
        Thread t3 = new Thread(() -> likeCounter.like());
        Thread t4 = new Thread(() -> likeCounter.like());
        Thread t5 = new Thread(() -> likeCounter.like());
        Thread t6 = new Thread(() -> likeCounter.like());
        Thread t7 = new Thread(() -> likeCounter.like());
        Thread t8 = new Thread(() -> likeCounter.like());
        Thread t9 = new Thread(() -> likeCounter.like());
        Thread t10 = new Thread(() -> likeCounter.like());

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();

        sleep(1000);

        System.out.println(likeCounter.getTotalLikes());
    }
}

class LikeCounter {

    AtomicReference<Integer> totalCount = new AtomicReference<>(0);
    Integer currentCount;
    Integer finalCount;
    public void like() {
        while(true){

            // we will capture the latest value of totalCount
            currentCount = totalCount.get();

            // increment the counter by 1
            finalCount = currentCount+1;

            // check again if the count is still what I saw
            if(totalCount.compareAndSet(currentCount, finalCount)) {
                return;
            }

            // if a thread reaches here, someone else must have updated the total count ie., the counter
            System.out.println("Conflict detected - Retrying...");
        }
    }

    public int getTotalLikes() {
        return totalCount.get();
    }
}
