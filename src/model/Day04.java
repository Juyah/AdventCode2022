package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Day04 {
    public static void main(String[] args) throws IOException {
        String file = "src/inputs/day04.txt";
        partOne(file);
        partTwo(file);
    }

    private static void partOne(String file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String value = reader.readLine();
        int fullyContainPairs = 0;
        while (value != null) {
            int[] sections = Arrays.stream(value.split("[-,]")).mapToInt(Integer::parseInt).toArray();
            System.out.println("Sections: " + Arrays.toString(sections));
            if ((sections[0] <= sections[2] && sections[1] >= sections[3]) || (sections[0] >= sections[2] && sections[1] <= sections[3])) {
                fullyContainPairs++;
            }
            value = reader.readLine();
        }
        System.out.println("Fully contain pairs: " + fullyContainPairs);
    }

    private static void partTwo(String file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String value = reader.readLine();
        int OverlapPairs = 0;
        while (value != null) {
            int[] sections = Arrays.stream(value.split("[-,]")).mapToInt(Integer::parseInt).toArray();
            if (!(sections[0] > sections[3] || sections[1] < sections[2])) {
                OverlapPairs++;
            }
            value = reader.readLine();
        }
        System.out.println("Overlap pairs: " + OverlapPairs);
    }
}
