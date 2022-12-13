package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Day10 {
    public static void main(String[] args) throws IOException {
        String file = "src/inputs/day10.txt";
        bothSolutions(file);
    }

    private static void bothSolutions(String file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));

        char[][] crtImage = new char[6][40];
        int x = 1;
        int cycle = 1;
        List<Integer> specialCycles = List.of(20, 60, 100, 140, 180, 220);
        int sumSignalStrength = 0;
        String lineInput = reader.readLine();
        while (lineInput != null) {
            int value = 0;
            crtImage[(cycle - 1) / 40][(cycle - 1) % 40] = Math.abs(x - ((cycle - 1) % 40)) <= 1 ? '#' : '.';
            cycle++;
            sumSignalStrength += specialCycles.contains(cycle) ? cycle * x : 0;
            if (!lineInput.equals("noop")) {
                value = Integer.parseInt(lineInput.split(" ")[1]);
                crtImage[(cycle - 1) / 40][(cycle - 1) % 40] = Math.abs(x - ((cycle - 1) % 40)) <= 1 ? '#' : '.';
                x += value;
                cycle++;
                sumSignalStrength += specialCycles.contains(cycle) ? cycle * x : 0;
            }
            System.out.printf("Value: %3d - X: %3d a Cycle %3d%n", value, x, cycle);
            lineInput = reader.readLine();
        }
        System.out.println("Total sum of the signal strength: " + sumSignalStrength);
        for (char[] chars : crtImage) {
            for (char aChar : chars) System.out.print(aChar);
            System.out.println();
        }
    }
}
