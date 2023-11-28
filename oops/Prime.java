public class Prime {

    private static int count = 0;

    class MyTh implements Runnable {
        private Thread th;
        private int start;
        private int end;

        public MyTh(int start, int end) {
            this.start = start;
            this.end = end;
            th = new Thread(this);
            th.start();
        }

        public void run() {
            try {
                System.out.println("Thread " + th.getId() + " running");
                for (int i = start; i <= end; i++) {
                    if (isPrime(i)) {
                        synchronized (Prime.class) {
                            count++;
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Thread interrupted");
            }
        }

        private boolean isPrime(int num) {
            if (num < 2) {
                return false;
            }
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        int n = 10000;
        int no_of_th = n / 100;

        MyTh[] mt = new MyTh[no_of_th];

        int rangePerThread = n / no_of_th;
        int startRange = 0;
        int endRange = rangePerThread - 1;

        for (int i = 0; i < no_of_th; i++) {
            mt[i] = new Prime().new MyTh(startRange, endRange);
            startRange = endRange + 1;
            endRange = (i == no_of_th - 2) ? n - 1 : endRange + rangePerThread;
        }

        // Wait for all threads to finish
        for (MyTh thread : mt) {
            try {
                thread.th.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Number of prime numbers in the range [0, " + n + "] is: " + count);
    }
}
