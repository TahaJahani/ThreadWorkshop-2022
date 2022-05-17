package Counter;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        System.out.println(counter.getNumber());
        Thread first = new User(1, counter);
        Thread second = new User(2, counter);
        first.start();
        second.start();
        first.join();
        second.join();
        System.out.println(counter.getNumber());
    }
}
