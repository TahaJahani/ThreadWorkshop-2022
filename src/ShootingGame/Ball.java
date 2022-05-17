package ShootingGame;

public class Ball {
    private int y;
    private boolean isMoving;

    public Ball(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isMoving() {
        return isMoving;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }

    public boolean move() {
        if (this.isMoving) {
            y = y - 1;
            return y != 0;
        }
        return true;
    }

    public char getSymbol() {
        return '●';
    }
}
