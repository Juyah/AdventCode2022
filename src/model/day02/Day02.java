package model.day02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day02 {

    public static void main(String[] args) throws IOException {
        String file = "src/inputs/day02.txt";
        firstPart(file);
        secondPart(file);
    }

    private static void firstPart(String file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));

        int totalPoints = 0;
        String value = reader.readLine();
        while (value != null) {
            String[] values = value.split(" ");
            HandShape elf = HandShape.getHandShape(values[0].charAt(0));
            HandShape human = HandShape.getHandShape(values[1].charAt(0));
            totalPoints += Outcome.getOutcome(elf, human).getValue() + human.getValue();

            System.out.println("Elf: " + elf + " - Human: " + human + " - Outcome: " + Outcome.getOutcome(elf, human).getValue() + " - Shape: " + human.getValue());

            value = reader.readLine();
        }
        System.out.println("Total points: " + totalPoints);
    }

    private static void secondPart(String file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));

        int totalPoints = 0;
        String value = reader.readLine();
        while (value != null) {
            String[] values = value.split(" ");
            HandShape elf = HandShape.getHandShape(values[0].charAt(0));
            Outcome neededOutcome = Outcome.getNeededOutcome(values[1].charAt(0));
            HandShape human = Outcome.getHandShape(elf, neededOutcome);

            totalPoints += neededOutcome.getValue() + human.getValue();

            System.out.println("Elf: " + elf + " - Human: " + human + " - Outcome: " + Outcome.getOutcome(elf, human).getValue() + " - Shape: " + human.getValue());

            value = reader.readLine();
        }
        System.out.println("Total points: " + totalPoints);
    }
}
