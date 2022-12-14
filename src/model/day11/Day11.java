package model.day11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day11 {
    public static void main(String[] args) throws IOException {
        String file = "src/inputs/day11.txt";
        partOne(file);
        partTwo(file);
    }

    private static void partOne(String file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));

        List<Monkey> monkeyList = new ArrayList<>();
        loadMonkeys(monkeyList, reader);


        for (int i = 0; i < 20; i++) {
            for (Monkey monkey : monkeyList) {
                while (monkey.hasItems()) {
                    long item = monkey.makeOperation(monkey.getItem()) / 3;
                    monkey.inspectItem();
                    int monkeyId = monkey.getTargetMonkey(item);
                    monkeyList.get(monkeyId).addNewItem(item);
                }
            }
        }

        System.out.println("Part one - Inspected items:" + getMaxInspectedItems(monkeyList));
    }

    private static void partTwo(String file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));

        List<Monkey> monkeyList = new ArrayList<>();
        int superMod = loadMonkeys(monkeyList, reader);

        for (int i = 0; i < 10000; i++) {
            for (Monkey monkey : monkeyList) {
                while (monkey.hasItems()) {
                    long item = monkey.makeOperation(monkey.getItem()) % superMod;
                    monkey.inspectItem();
                    int monkeyId = monkey.getTargetMonkey(item);
                    monkeyList.get(monkeyId).addNewItem(item);
                }
            }
        }

        System.out.println("Part two - Inspected items:" + getMaxInspectedItems(monkeyList));
    }

    private static int loadMonkeys(List<Monkey> monkeyList, BufferedReader reader) throws IOException {
        String lineInput = null;
        int superMod = 1;
        do {
            int monkeyId = Integer.parseInt(reader.readLine().split(" ")[1].substring(0, 1));
            String[] startingItems = reader.readLine().split(":")[1].split(",");
            List<Long> startingItemsList = new ArrayList<>();
            for (String startingItem : startingItems) {
                startingItemsList.add(Long.parseLong(startingItem.trim()));
            }
            String operation = reader.readLine().split("new = old")[1].trim();
            char operationType = operation.charAt(0);
            int operationValue = 0;
            if (!operation.substring(2).equals("old")) operationValue = Integer.parseInt(operation.substring(2));
            int divisibleBy = Integer.parseInt(reader.readLine().split("by")[1].trim());
            superMod *= divisibleBy;
            int ifTrue = Integer.parseInt(reader.readLine().split("monkey")[1].trim());
            int ifFalse = Integer.parseInt(reader.readLine().split("monkey")[1].trim());
            monkeyList.add(new Monkey(monkeyId, startingItemsList, operationType, operationValue, divisibleBy, ifTrue, ifFalse));

            lineInput = reader.readLine();
        } while (lineInput != null);

        return superMod;
    }

    private static Long getMaxInspectedItems(List<Monkey> monkeyList) {
        long max1 = 0;
        long max2 = 0;
        for (Monkey monkey : monkeyList) {
            if (monkey.getInspectedItems() > max1) {
                max2 = max1;
                max1 = monkey.getInspectedItems();
            } else if (monkey.getInspectedItems() > max2) {
                max2 = monkey.getInspectedItems();
            }
        }
        return max1 * max2;
    }
}
