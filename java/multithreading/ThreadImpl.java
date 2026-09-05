package multithreading;

import static java.lang.Thread.currentThread;

class ThreadClass extends Thread{

    @Override
    public void run(){
        System.out.println("Thread creating using Thread class");
    }
}

class RunnableImpl implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread creating using Runnable interface");
    }
}

public class ThreadImpl {
    static void main() throws InterruptedException {
        // Using Custom thread class extending Thread class
        ThreadClass thread = new ThreadClass();
        thread.start();
        System.out.println(currentThread().getName());

        // Using runnable interface
        RunnableImpl runnable = new RunnableImpl(); //task created
        Thread thread2 = new Thread();
        thread2.start(); //no error but nothing in run method will be executed
        System.out.println(currentThread().getName()); // CREATED THREAD HAS TERMINATED, SO MAIN THREAD INFO WILL BE PRINTED

        // using Anonymous class
        Thread thread3 = new Thread(
                new Runnable(){
                    @Override
                    public void run() {
                        System.out.println("Running thread from anonymous class"); //no need to implement runnable interface
                    }
                }
        );
        thread3.start();
        System.out.println(currentThread().getName());
        thread3.join();

        // Using lambda expression
        Thread thread4 = new Thread( () -> {
            System.out.println(currentThread().getName());
            System.out.println("Running thread from lambda exp"); //no need to implement runnable interface
        }
        );
        System.out.println("Thread is in " + thread4.getState());

        thread4.start();
        // System.out.println(currentThread().getName());
        System.out.println("Thread is in " + thread4.getState());





    }

}
