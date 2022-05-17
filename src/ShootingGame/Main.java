package ShootingGame;

import java.io.IOException;

public class Main {
    // Run stty cbreak && java ShootingGame.Main
    public static void main(String[] args) throws IOException {
        Board board = new Board(80, 12, 3);
        Thread gameThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        board.step();
                        board.print();
                        Thread.sleep(60);
                    }
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        gameThread.setDaemon(true);
        gameThread.start();
        while (true) {
            if (getInput(board))
                break; // To exit loop and end game
        }
        // Main thread ends here
    }

    private static boolean getInput(Board board) throws IOException {
        int c = System.in.read();
        if (c == 32) {
            board.shoot();
        } else if (c == 27) {
            return true;
        }
        return false;
    }
}
