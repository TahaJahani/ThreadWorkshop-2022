package ShootingGame;

public class Board {
    private int numGoals = 3;
    private char[][] board;
    private int width, height;
    private Ball ball;
    private Goal[] goals;

    public Board(int width, int height, int numGoals) {
        this.numGoals = numGoals;
        this.board = new char[width][height];
        this.width = width;
        this.height = height;
        this.ball = new Ball(this.height - 2);
        this.goals = new Goal[numGoals];
        initGoals();
    }

    public void restartBoard() {
        for (int i = 0 ; i < height ; i++) {
            for (int j = 0 ; j < width ; j++) {
                board[j][i] = ' ';
            }
        }
        for (int i = 0 ; i < width ; i++) {
            board[i][0] = board[i][height - 1] = '═';
        }
        for (int j = 0 ; j < height ; j++) {
            board[width - 1][j] = '║';
            board[0][j] = '║';
        }
        board[width - 1][height - 1] = '╝';
        board[0][0] = '╔';
        board[width - 1][0] = '╗';
        board[0][height - 1] = '╚';
        board[getGunX() - 1][getGunY()] = '⎿';
        board[getGunX() + 1][getGunY()] = '⏌';
    }

    public void step() {
        if (!ball.move()) {
            ball.setY(getGunY());
            ball.setMoving(false);
        }
        for (int i = 0 ; i < numGoals ; i++) {
            goals[i].move();
            if (goals[i].getY() == ball.getY() && goals[i].getX() == getGunX())
                goals[i].setDead(true);
        }
        restartBoard();
        board[getGunX()][ball.getY()] = ball.getSymbol();
        for (int i = 0 ; i < numGoals ; i++) {
            Goal goal = goals[i];
            board[goal.getX()][goal.getY()] = goal.getSymbol();
        }
    }

    public void print() {
        System.out.print("\033[H\033[2J");
        for (int i = 0 ; i < height ; i++) {
            for (int j = 0 ; j < width ; j++) {
                System.out.print(board[j][i]);
            }
            System.out.print("\n");
        }
    }

    public void shoot() {
        this.ball.setMoving(true);
    }

    private int getGunX() {
        return (this.width / 2) - 1;
    }

    private int getGunY() {
        return this.height - 2;
    }

    private void initGoals() {
        for (int i = 0 ; i < numGoals ; i++) {
            char dir = i % 2 == 0 ? 'L' : 'R';
            this.goals[i] = new Goal(this.width / 2, i + 1, dir, width);
        }
    }

}
