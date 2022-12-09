package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Day06 {

    public static void main(String[] args) throws IOException {
        String file = "src/inputs/day06.txt";
        bothSolutions(file, 4);
        bothSolutions(file, 14);
    }

    private static void bothSolutions(String file, int markerSize) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String message = reader.readLine();
        int charsProcessed = 0;
        int subCharsLength;
        do {
            String subChars = message.substring(charsProcessed, charsProcessed + markerSize);
            Set<Character> chars = new HashSet<>();
            for (char c : subChars.toCharArray()) chars.add(c);
            subCharsLength = chars.size();
            charsProcessed++;
        } while (subCharsLength != markerSize);
        System.out.println(charsProcessed + markerSize - 1);
    }
}
