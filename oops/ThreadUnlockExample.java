
public class ThreadUnlockExample {
    public static void main(String[] args) {
        final Object lock = new Object();

        Thread waitingThread1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("Thread 1 is waiting.");
                    lock.wait(); // Thread 1 waits indefinitely
                    System.out.println("Thread 1 is awake!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread waitingThread2 = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("Thread 2 is waiting.");
                    lock.wait(); // Thread 2 waits indefinitely
                    System.out.println("Thread 2 is awake!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread waitingThread3 = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("Thread 3 is waiting.");
                    lock.wait(); // Thread 2 waits indefinitely
                    System.out.println("Thread 3 is awake!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
         
        waitingThread1.start();
        waitingThread2.start();
        waitingThread3.start();


        try {
            Thread.sleep(2000); // Sleep for a while
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (lock) {
            lock.notify(); // Wake up one waiting thread
        }

        try {
            Thread.sleep(2000); // Sleep for a while
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (lock) {
            lock.notifyAll(); // Wake up all waiting threads
        }
    }
}
