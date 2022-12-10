package model.day09;

public class Knot {
    private int x;
    private int y;

    public Knot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void moveRight() {
        x++;
    }

    public void moveLeft() {
        x--;
    }

    public void moveUp() {
        y++;
    }

    public void moveDown() {
        y--;
    }

    public boolean isInRange(int x, int y) {
        boolean xInRange = Math.abs(x - this.x) <= 1;
        boolean yInRange = Math.abs(y - this.y) <= 1;
        return xInRange && yInRange;
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }

    public boolean isDiagonal(int x, int y) {
        return Math.abs(x - this.x) >= 1 && Math.abs(y - this.y) >= 1;
    }

    public Direction[] getDiagonalDirections(int x, int y) {
        Direction[] directions = new Direction[2];
        if (x > this.x) {
            directions[0] = Direction.RIGHT;
        } else {
            directions[0] = Direction.LEFT;
        }
        if (y > this.y) {
            directions[1] = Direction.UP;
        } else {
            directions[1] = Direction.DOWN;
        }
        return directions;
    }

    public Direction getDirection(int x, int y) {
        if (x > this.x) {
            return Direction.RIGHT;
        } else if (x < this.x) {
            return Direction.LEFT;
        } else if (y > this.y) {
            return Direction.UP;
        } else {
            return Direction.DOWN;
        }
    }
}
