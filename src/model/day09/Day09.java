package model.day09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Day09 {
    public static void main(String[] args) throws IOException {
        String file = "src/inputs/day09.txt";
        partOne(file);
        partTwo(file);
    }

    private static void partTwo(String file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));

        Knot head = new Knot(0, 0);
        Knot[] tail = new Knot[9];
        for (int i = 0; i < 9; i++) {
            tail[i] = new Knot(0, 0);
        }
        Set<String> visited = new HashSet<>();

        visited.add(tail[8].toString());
        String lineInput = reader.readLine();
        while (lineInput != null) {
            String[] motion = lineInput.split(" ");
            Direction direction = Direction.getDirection(motion[0]);
            int steps = Integer.parseInt(motion[1]);

            for (int i = 0; i < steps; i++) {
                direction.move(head);
                if (!tail[0].isInRange(head.getX(), head.getY())) {
                    if (tail[0].isDiagonal(head.getX(), head.getY())) {
                        Direction[] directions = tail[0].getDiagonalDirections(head.getX(), head.getY());
                        directions[0].move(tail[0]);
                        directions[1].move(tail[0]);
                    } else {
                        tail[0].getDirection(head.getX(), head.getY()).move(tail[0]);
                    }
                }
                for (int j = 0; j < 8; j++) {
                    if (!tail[j + 1].isInRange(tail[j].getX(), tail[j].getY())) {
                        if (tail[j + 1].isDiagonal(tail[j].getX(), tail[j].getY())) {
                            Direction[] directions = tail[j + 1].getDiagonalDirections(tail[j].getX(), tail[j].getY());
                            directions[0].move(tail[j + 1]);
                            directions[1].move(tail[j + 1]);
                        } else {
                            tail[j + 1].getDirection(tail[j].getX(), tail[j].getY()).move(tail[j + 1]);
                        }
                    }
                }
                visited.add(tail[8].toString());
            }
            lineInput = reader.readLine();
        }

        System.out.println("Positions does the last tail of the rope visit at least once: " + visited.size());
    }

    private static void partOne(String file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));

        Knot tail = new Knot(0, 0);
        Knot head = new Knot(0, 0);
        Set<String> visited = new HashSet<>();

        visited.add(tail.toString());
        String lineInput = reader.readLine();
        while (lineInput != null) {
            String[] motion = lineInput.split(" ");
            Direction direction = Direction.getDirection(motion[0]);
            int steps = Integer.parseInt(motion[1]);

            for (int i = 0; i < steps; i++) {
                direction.move(head);
                if (!tail.isInRange(head.getX(), head.getY())) {
                    if (tail.isDiagonal(head.getX(), head.getY())) {
                        Direction[] directions = tail.getDiagonalDirections(head.getX(), head.getY());
                        directions[0].move(tail);
                        directions[1].move(tail);
                    } else {
                        direction.move(tail);
                    }
                }
                visited.add(tail.toString());
            }
            lineInput = reader.readLine();
        }

        System.out.println("Positions does the tail of the rope visit at least once: " + visited.size());
    }
}


