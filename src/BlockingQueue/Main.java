package BlockingQueue;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BlockingQueue q = new BlockingQueue(100);
        q.enqueue("first");
        q.enqueue("second");
        Consumer c = new Consumer("c1", q);
        new Thread(c).start();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String data = scanner.nextLine();
            q.enqueue(data);
        }

    }
}
