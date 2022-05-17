package BlockingQueue;

public class Consumer implements Runnable {

    private BlockingQueue queue;
    private String name;

    public Consumer(String name, BlockingQueue queue) {
        this.queue = queue;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String data = queue.dequeue();
                System.out.printf("%s: , data: %s\n", this.name, data);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
