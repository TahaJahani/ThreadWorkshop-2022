package Counter;

public class User extends Thread{

    private Counter counter;
    private int index;

    public User(int index, Counter counter) {
        super();
        this.index = index;
        this.counter = counter;
    }
    @Override
    public void run() {
        for (int i = 0 ; i < 5 ; i++) {
            counter.countUp();
        }
        System.out.printf("user with index %d finished\n", this.index);
    }
}
