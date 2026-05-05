public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world! ->"+Thread.currentThread() );

        Runnable runnable = ()->System.out.println("Enter Thread 1 ->"+Thread.currentThread());
        Thread t1 = new Thread(runnable);
        t1.start();

        Runnable runnable1 = new Runnable(){
            public  void doSomething(){
                System.out.println("Enter Thread 4 ->"+Thread.currentThread());

            }
            @Override
            public void run(){
                System.out.println("Enter Thread 3 ->"+Thread.currentThread());
                doSomething();
            }
        };
        Thread t2 = new Thread(runnable);
        t2.start();
        Thread t3 = new Thread(runnable);
        t3.start();
        System.out.println("Enter Thread 2 ->"+Thread.currentThread());
    }
}