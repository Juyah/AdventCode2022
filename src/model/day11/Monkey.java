package model.day11;

import java.util.List;

public class Monkey {
    private int id;
    private int inspectedItems = 0;
    private List<Long> startingItems;
    private char operationType;
    private int operationValue;
    private int divisibleBy;
    private int ifTrue;
    private int ifFalse;

    public Monkey(int id, List<Long> startingItems, char operationType, int operationValue, int divisibleBy, int ifTrue, int ifFalse) {
        this.id = id;
        this.startingItems = startingItems;
        this.operationType = operationType;
        this.operationValue = operationValue;
        this.divisibleBy = divisibleBy;
        this.ifTrue = ifTrue;
        this.ifFalse = ifFalse;
    }

    //override toString() method
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder("Monkey " + id + ": ");
        for (long startingItem : startingItems) {
            output.append(startingItem).append(", ");
        }
        output = new StringBuilder(output.substring(0, output.length() - 2));
        return output.toString();
    }

    public long getItem() {
        return startingItems.remove(0);
    }

    public long makeOperation(long item) {
        int newNumber = 0;
        long valueToOperate = operationValue > 0 ? operationValue : item;
        return switch (operationType) {
            case '+' -> item + valueToOperate;
            case '*' -> item * valueToOperate;
            default -> newNumber;
        };
    }

    public int getTargetMonkey(long item) {
        return item % divisibleBy == 0 ? ifTrue : ifFalse;
    }

    public void addNewItem(long item) {
        startingItems.add(item);
    }

    public boolean hasItems() {
        return !startingItems.isEmpty();
    }

    public void inspectItem() {
        inspectedItems++;
    }

    public int getInspectedItems() {
        return inspectedItems;
    }
}
