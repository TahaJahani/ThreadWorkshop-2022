package BlockingQueue;

public class BlockingQueue {
    private String[] array;
    private int head = 0;
    private int tail = 0;
    private final int size;
    private final String myString = "";

    public BlockingQueue(int size) {
        array = new String[size];
        this.size = size;
    }

    // acquire lock
    public synchronized void enqueue(String data) {
        array[head] = data;
        head++;
        head %= size;
        this.notify();
    }

    public synchronized String dequeue() throws InterruptedException {
        while (head == tail) {
            this.wait();
        }
        String toReturn = array[tail];
        tail++;
        tail %= size;
        return toReturn;
    }
}
