public class Thread_test extends Thread {
    public static int amount = 0;
  
    public static void main(String[] args) {
        Thread_test thread = new Thread_test();
      thread.start();
      // Wait for the thread to finish
      while(thread.isAlive()) {
        System.out.println("Waiting...");
      }
      // Update amount and print its value
      System.out.println("Main: " + amount);
      amount++;
      System.out.println("Main: " + amount);
    }
    public void run() {
      amount++;
          System.out.println("inside thread "+amount);
    }
  }
  