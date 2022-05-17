package ShootingGame;

public class Goal {
    private int x,y;
    private int direction;
    private int boardWith;
    private boolean isDead = false;

    public Goal(int x, int y, char direction, int boardWith) {
        this.x = x;
        this.y = y;
        this.direction = direction == 'L' ? -1 : 1;
        this.boardWith = boardWith;
    }

    public void move() {
        this.x += this.direction;
        if (x >= boardWith - 2 || x <= 1)
            this.direction *= -1;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public char getSymbol() {
        return  isDead ? ' ' : '━';
    }
}
