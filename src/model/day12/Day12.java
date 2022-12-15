package model.day12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Day12 {
    public static void main(String[] args) throws IOException {
        String file = "src/inputs/day12.txt";
        partOne(file);
        partTwo(file);
    }

    private static void partTwo(String file) throws IOException {
        Node start = new Node(0, 0);
        Node end = new Node(0, 0);
        int[][] rawMatrix = getRawMatrix(file, end, start);
        Matrix matrix = new Matrix(rawMatrix);
        matrix.part1 = false;
        Explorer explorer = new Explorer(matrix, start);
        while (explorer.isExploring()) {
            Node exploringPos = explorer.explore();
            if (rawMatrix[exploringPos.row][exploringPos.column] == 0) {
                System.out.println("Part 2: " + explorer.distances[exploringPos.row][exploringPos.column]);
                return;
            }
        }
        System.out.println(Arrays.deepToString(rawMatrix).replace("],", "],\n"));
        System.out.println(Arrays.deepToString(explorer.distances).replace("],", "],\n"));
    }


    private static void partOne(String file) throws IOException {
        Node start = new Node(0, 0);
        Node end = new Node(0, 0);
        int[][] rawMatrix = getRawMatrix(file, start, end);
        Matrix matrix = new Matrix(rawMatrix);
        Explorer explorer = new Explorer(matrix, start);
        while (explorer.isExploring()) {
            Node exploringPos = explorer.explore();
            if (end.row == exploringPos.row && end.column == exploringPos.column) {
                System.out.println("Part 1: " + explorer.distances[exploringPos.row][exploringPos.column]);
                return;
            }
        }
        System.out.println(Arrays.deepToString(rawMatrix).replace("],", "],\n"));
        System.out.println(Arrays.deepToString(explorer.distances).replace("],", "],\n"));
    }

    private static int getCharValue(char val) {
        if (val == 'S') return 0;
        if (val == 'E') return 'z' - 'a';
        return val - 'a';
    }

    private static int[][] getRawMatrix(String file, Node start, Node end) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));

        List<String> linesInput = reader.lines().toList();
        int[][] rawMatrix = new int[linesInput.size()][linesInput.get(0).length()];
        for (int i = 0; i < linesInput.size(); i++) {
            String lineInput = linesInput.get(i);
            for (int j = 0; j < lineInput.length(); j++) {
                if (lineInput.charAt(j) == 'S') {
                    start.row = i;
                    start.column = j;
                } else if (lineInput.charAt(j) == 'E') {
                    end.row = i;
                    end.column = j;
                }
                rawMatrix[i][j] = getCharValue(lineInput.charAt(j));
            }
        }
        return rawMatrix;
    }
}
