package multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static java.lang.Thread.sleep;

public class ReaderWriterProblem {
    static void main() {
        SharedResource sharedResource = new SharedResource();

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

class SharedResource {
    private int value = 0;

    ReadWriteLock rwLock = new ReentrantReadWriteLock();
    Lock rl = rwLock.readLock(); //shared lock - SL
    Lock wl = rwLock.writeLock(); //exclusive lock - XL

    public int read() {
        rl.lock();
        try {
            try {
                sleep(1000);
            } catch (Exception _){}
            System.out.println(Thread.currentThread().getName()+" reads value as "+ value);
            return this.value;
        } finally {
            rl.unlock();
        }
    }

    public void write(int newValue) {
        wl.lock();
        try {
            try {
                sleep(1000);
            } catch (Exception _){}
            this.value = newValue;
            System.out.println(Thread.currentThread().getName()+" changes value to "+ newValue);
        } finally {
            wl.unlock();
        }
    }

}
