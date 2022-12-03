package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day03 {
    public static void main(String[] args) throws IOException {
        String file = "src/inputs/day03.txt";
        partOne(file);
        partTwo(file);
    }

    private static void partOne(String file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String value = reader.readLine();
        int sumOfPriorities = 0;
        while (value != null) {
            String wordOne = value.substring(0, value.length() / 2);
            String wordTwo = value.substring(value.length() / 2);

            char sharedChar = getSharedChar(wordOne, wordTwo);
            sumOfPriorities += getPriority(sharedChar);

            System.out.println("Word: " + value + " / " + wordOne + " - " + wordTwo + " / " + sharedChar + " " + getPriority(sharedChar));
            value = reader.readLine();
        }
        System.out.println("Sum of priorities: " + sumOfPriorities);
    }

    private static void partTwo(String file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String wordOne = reader.readLine();
        int sumOfPriorities = 0;
        while (wordOne != null) {
            String wordTwo = reader.readLine();
            String wordThree = reader.readLine();

            char sharedChar = getSharedChar(wordOne, wordTwo, wordThree);
            sumOfPriorities += getPriority(sharedChar);

            System.out.println(wordOne + " / " + wordTwo + " / " + wordThree + " / " + sharedChar + " " + getPriority(sharedChar));
            wordOne = reader.readLine();
        }
        System.out.println("Sum of priorities: " + sumOfPriorities);

    }

    private static int getPriority(char sharedChar) {
        return Character.isLowerCase(sharedChar) ? sharedChar - 96 : sharedChar - 38;
    }

    private static char getSharedChar(String wordOne, String wordTwo) {
        for (int c : wordOne.chars().toArray()) {
            if (wordTwo.contains(String.valueOf((char) c))) {
                return (char) c;
            }
        }
        return 0;
    }

    private static char getSharedChar(String wordOne, String wordTwo, String wordThree) {
        for (int c : wordOne.chars().toArray()) {
            if (wordTwo.contains(String.valueOf((char) c)) && wordThree.contains(String.valueOf((char) c))) {
                return (char) c;
            }
        }
        return 0;
    }
}
