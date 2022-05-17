package Counter;

public class Counter {
    private int number = 0;

    public synchronized void countUp() {
        int next = number;
        next = next + 1;
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.number = next;
    }

    public int getNumber() {
        return number;
    }
}
