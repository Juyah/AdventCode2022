package model.day02;

public enum HandShape {
    ROCK('A', 'X', 1, 'Z'), PAPER('B', 'Y', 2, 'X'), SCISSORS('C', 'Z', 3, 'Y');

    public final char elfPick;
    public final char humanPick;
    public final int value;
    public final char beats;
    HandShape(char elfPick, char humanPick, int value, char beats) {
        this.elfPick = elfPick;
        this.humanPick = humanPick;
        this.value = value;
        this.beats = beats;
    }

    public static HandShape getHandShape(char c) {
        for (HandShape handShape : HandShape.values()) {
            if (handShape.elfPick == c || handShape.humanPick == c) {
                return handShape;
            }
        }
        return null;
    }

    public int getValue() {
        return value;
    }

    public boolean isBetterThan(HandShape human) {
        return this.beats == human.humanPick;
    }
}

