package multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

import static java.lang.Thread.sleep;

public class StampedeLockImp {
    static void main() {
        SharedResourceStampede sharedResource = new SharedResourceStampede();

        Thread r1 = new Thread(sharedResource::read);
        Thread r2 = new Thread(sharedResource::read);
        Thread r3 = new Thread(sharedResource::read);

        Thread w1 = new Thread(() -> sharedResource.write(5));
        Thread w2 = new Thread(() -> sharedResource.write(7));
        Thread w3 = new Thread(() -> sharedResource.write(9));

        r1.start();
        r2.start();
        r3.start();

        w1.start();
        w2.start();
        w3.start();
    }
}

class SharedResourceStampede {
    private int value = 0;

    StampedLock lock = new StampedLock();

    public int read() {
        long stamp = lock.tryOptimisticRead();
        int currentValue = value;

        try {
            sleep(1000);
        } catch (Exception _){}

        if(!lock.validate(stamp)){
            //fallover logic
            //try pessimistic read
            stamp = lock.readLock();
            try {
              currentValue = value;
            } finally {
                lock.unlockRead(stamp);
            }
        }
        System.out.println(Thread.currentThread().getName()+" reads value as "+ value);
        return currentValue;
    }

    public void write(int newValue) {
        long stamp = lock.writeLock();
        try {
            try {
                sleep(1000);
            } catch (Exception _){}
            this.value = newValue;
            System.out.println(Thread.currentThread().getName()+" changes value to "+ newValue);
        } finally {
            lock.unlockWrite(stamp);
        }
    }

}
