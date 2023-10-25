// Question 2: Explain the different states a thread can be in (e.g., NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING, TERMINATED).

public class ThreadStatesExample {
    public static void main(String[] args) {
        // Create a thread in the NEW state
        Thread newThread = new Thread(() -> {
            System.out.println("Thread in NEW state.");
        });

        // Start the thread, moving it to the RUNNABLE state
        newThread.start();

        // Create a thread in the TIMED_WAITING state (sleep for 2 seconds)
        Thread timedWaitingThread = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread in TIMED_WAITING state.");
        });

        timedWaitingThread.start();

        // Create a thread in the BLOCKED state (simulate lock contention)
        final Object lock = new Object();
        Thread blockingThread1 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Thread in BLOCKED state (1st).");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread blockingThread2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Thread in BLOCKED state (2nd).");
            }
        });

        blockingThread1.start();
        blockingThread2.start();

        // Create a thread in the WAITING state (wait indefinitely)
        Thread waitingThread = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait(); // Wait indefinitely
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread in WAITING state.");
            }
        });

        waitingThread.start();
    }
}
