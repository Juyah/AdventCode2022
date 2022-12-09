package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Day08 {
    public static void main(String[] args) throws IOException {
        String file = "src/inputs/day08.txt";
        bothSolutions(file);
    }

    private static void bothSolutions(String file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));

        List<String> values = reader.lines().toList();
        int rows = values.size();
        int columns = values.get(0).length();
        int[][] treeGrid = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            String[] row = values.get(i).split("");
            for (int j = 0; j < columns; j++) {
                treeGrid[i][j] = Integer.parseInt(row[j]);
            }
        }

        int visibleTrees = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i == 0 || i == rows - 1 || j == 0 || j == columns - 1 || isTheMaxValue(treeGrid, i, j)) {
                    visibleTrees++;
                }
            }
        }
        System.out.println("Visible trees: " + visibleTrees);

        int maxScore = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (!(i == 0 || i == rows - 1 || j == 0 || j == columns - 1)) {
                    maxScore = Math.max(maxScore, getScore(treeGrid, i, j));
                }
            }
        }
        System.out.println("Highest scenic score: " + maxScore);
    }

    private static int getScore(int[][] treeGrid, int row, int column) {
        int value = treeGrid[row][column];
        int upperTrees = 0;
        int lowerTrees = 0;
        int leftTrees = 0;
        int rightTrees = 0;

        for (int i = row - 1; i >= 0; i--) {
            if (treeGrid[i][column] >= value) {
                upperTrees = row - i;
                break;
            } else {
                upperTrees = row;
            }
        }

        for (int i = row + 1; i <= treeGrid.length - 1; i++) {
            if (treeGrid[i][column] >= value) {
                lowerTrees = i - row;
                break;
            } else {
                lowerTrees = treeGrid.length - 1 - row;
            }
        }

        for (int i = column - 1; i >= 0; i--) {
            if (treeGrid[row][i] >= value) {
                leftTrees = column - i;
                break;
            } else {
                leftTrees = column;
            }
        }
        for (int i = column + 1; i <= treeGrid[0].length - 1; i++) {
            if (treeGrid[row][i] >= value) {
                rightTrees = i - column;
                break;
            } else {
                rightTrees = treeGrid[0].length - 1 - column;
            }
        }

        return upperTrees * lowerTrees * leftTrees * rightTrees;
    }

    private static boolean isTheMaxValue(int[][] treeGrid, int row, int column) {
        int value = treeGrid[row][column];
        boolean upperTrees = true;
        boolean lowerTrees = true;
        boolean leftTrees = true;
        boolean rightTrees = true;

        for (int i = 0; i < row; i++) {
            if (treeGrid[i][column] >= value) {
                upperTrees = false;
                break;
            }
        }
        for (int i = treeGrid.length - 1; i > row; i--) {
            if (treeGrid[i][column] >= value) {
                lowerTrees = false;
                break;
            }
        }
        for (int i = 0; i < column; i++) {
            if (treeGrid[row][i] >= value) {
                leftTrees = false;
                break;
            }
        }
        for (int i = treeGrid[0].length - 1; i > column; i--) {
            if (treeGrid[row][i] >= value) {
                rightTrees = false;
                break;
            }
        }
        return upperTrees || lowerTrees || leftTrees || rightTrees;
    }
}
