public class SynchronizationExample {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        // Create two threads
        Thread thread1 = new Thread(() -> {
            sharedResource.incrementWithMethod();
        });

        Thread thread2 = new Thread(() -> {
            sharedResource.incrementWithBlock();
        });

        // Start the threads
        thread1.start();
        thread2.start();

        try {
            // Wait for both threads to finish
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print the final count
        System.out.println("Final Count: " + sharedResource.getCount());
    }

    static class SharedResource {
        private int count = 0;

        // Synchronized method
        public synchronized void incrementWithMethod() {
            for (int i = 0; i < 1000; i++) {
                count++;
            }
        }

        // Synchronized block
        public void incrementWithBlock() {
            synchronized (this) {
                for (int i = 0; i < 1000; i++) {
                    count++;
                }
            }
        }

        public int getCount() {
            return count;
        }
    }
}
