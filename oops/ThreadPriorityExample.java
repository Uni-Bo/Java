// Question 3: Discuss thread priorities in Java. How can you set and get the priority of a thread? What are the valid thread priority values?

public class ThreadPriorityExample {
    public static void main(String[] args) {
        // Create two threads
        Thread thread1 = new Thread(new MyRunnable());
        Thread thread2 = new Thread(new MyRunnable());

        // Set thread priorities
        thread1.setPriority(1); // Lowest priority
        thread2.setPriority(10); // Highest priority

        // Start the threads
        thread1.start();
        thread2.start();

        // Get and display thread priorities
        int priority1 = thread1.getPriority();
        int priority2 = thread2.getPriority();

        System.out.println("Thread 1 priority: " + priority1);
        System.out.println("Thread 2 priority: " + priority2);
    }

    static class MyRunnable implements Runnable {
        public void run() {
            Thread currentThread = Thread.currentThread();
            int priority = currentThread.getPriority();
            System.out.println("Thread " + currentThread.getName() + " has priority " + priority);
        }
    }
}
