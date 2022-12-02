package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Day01 {
    public static void main(String[] args) throws IOException {
        String file = "src/inputs/day01.txt";
        bothSolutions(file);
    }
    private static void bothSolutions(String file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));

        ArrayList<Integer> maxCalories = new ArrayList<>(Arrays.asList(0, 0, 0));
        int actualCalories = 0;
        int elfCount = 1;
        String value = reader.readLine();
        while (value != null) {
            if (value.isBlank()) {
                if(Collections.min(maxCalories) < actualCalories) {
                    maxCalories.set(maxCalories.indexOf(Collections.min(maxCalories)), actualCalories);
                }
                System.out.println("Elf " + elfCount++ + " total calories: " + actualCalories);
                actualCalories = 0;
            } else {
                actualCalories += Integer.parseInt(value);
            }
            value = reader.readLine();
        }

        System.out.println("Part one - Most calories carried by top Elf: " + Collections.max(maxCalories));
        System.out.println("Part two - Most calories carried by top three Elves: " + maxCalories.stream().mapToInt(Integer::intValue).sum());

        reader.close();
    }
}
