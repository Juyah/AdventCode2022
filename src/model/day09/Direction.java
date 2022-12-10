package model.day09;

public enum Direction {
    RIGHT("R"), LEFT("L"), UP("U"), DOWN("D");

    private final String value;

    Direction(String value) {
        this.value = value;
    }

    public static Direction getDirection(String value) {
        for (Direction direction : Direction.values()) {
            if (direction.getValue().equals(value)) {
                return direction;
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }

    public void move(Knot knot) {
        switch (this) {
            case RIGHT:
                knot.moveRight();
                break;
            case LEFT:
                knot.moveLeft();
                break;
            case UP:
                knot.moveUp();
                break;
            case DOWN:
                knot.moveDown();
                break;
        }
    }

    public boolean equals(Direction direction) {
        return this == direction;
    }
}
