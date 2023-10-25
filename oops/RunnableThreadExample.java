class MyRunnable implements Runnable {
    public void run() {
        System.out.println("This is a thread created by implementing the Runnable interface.");
    }
}

public class RunnableThreadExample {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start(); // Start the thread
    }
}
