package model.day02;

public enum Outcome {
    WIN(6, 'Z'), LOSE(0, 'X'), DRAW(3, 'Y');

    public final int value;
    public final char neededOutcome;
    private Outcome(int value, char neededOutcome) {
        this.value = value;
        this.neededOutcome = neededOutcome;
    }

    public int getValue() {
        return value;
    }

    public static Outcome getNeededOutcome(char c) {
        for (Outcome outcome : Outcome.values()) {
            if (outcome.neededOutcome == c) {
                return outcome;
            }
        }
        return null;
    }

    public static HandShape getHandShape(HandShape elf, Outcome neededOutcome) {
        for (HandShape handShape : HandShape.values()) {
            if (neededOutcome == getOutcome(elf, handShape)) {
                return handShape;
            }
        }
        return null;
    }
    public static Outcome getOutcome(HandShape elf, HandShape human) {
        if (elf == human) {
            return Outcome.DRAW;
        } else if (elf.isBetterThan(human)) {
            return Outcome.LOSE;
        } else {
            return Outcome.WIN;
        }
    }
}
