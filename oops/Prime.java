class MyTh implements Runnable {
    private Thread th;
    private int start;
    private int end;

    public MyTh(int start, int end) {
        this.start = start;
        this.end = end;
        this.th = new Thread(this);
    }

    public void startThread() {
        th.start();
    }

    public void end()
    {
        try{
            th.join();
        }catch (InterruptedException e) {
                e.printStackTrace();
        }
    }

    public void run() {
        try {
            System.out.println("Thread " + th.getId() + " running");
            for (int i = start; i <= end; i++) {
                if (isPrime(i)) {
                    synchronized (Prime.class) {
                        Prime.count++;
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

public class Prime {
    public static int count = 0;

    public static void main(String[] args) {
        int n = 10000;
        int no_of_th = n / 100;

        MyTh[] mt = new MyTh[no_of_th];

        int rangePerThread = 100;
        int startRange = 0;
        int endRange = rangePerThread - 1;

        for (int i = 0; i < no_of_th; i++) {
            mt[i] = new MyTh(startRange, endRange);
            mt[i].startThread();
            startRange = endRange + 1;
            endRange = (i == no_of_th - 2) ? n - 1 : endRange + rangePerThread;
        }

        for (MyTh thread : mt) {
            try {
                thread.end();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("Number of prime numbers in the range [0, " + n + "] is: " + count);
    }
}
