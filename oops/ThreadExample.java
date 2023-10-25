public class ThreadExample 
{
    public static void main(String[] args)
    {
        MyThread mt= new MyThread();
        mt.start();
        System.out.println("Outside Thread ");

    }
}

class MyThread extends Thread
{
    public void run()
    {
        System.out.println("Inside Thread ");
    }

}