package ThreadStart;

public class Main {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
        Thread t2 = new Thread(new MyRunnable());
        t2.start();
        System.out.println("Main Thread");
    }
}
