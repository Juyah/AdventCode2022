package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.deepToString;

public class Day05 {
    public static void main(String[] args) throws IOException {
        String file = "src/inputs/day05.txt";
        partOne(file);
        partTwo(file);
    }

    private static void partOne(String file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));

        ArrayList<String[]> list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            list.add((reader.readLine().split(" ")));
        }
        System.out.println(deepToString(list.toArray()));

        String value = reader.readLine();
        while (value != null) {
            String[] movement = value.split(" ");
            int quantity = Integer.parseInt(movement[1]);
            int from = Integer.parseInt(movement[3]);
            int to = Integer.parseInt(movement[5]);

            int size = list.get(from - 1).length;
            List<String> listFrom = new ArrayList<>(Arrays.asList(list.get(from - 1)));
            List<String> listTo = new ArrayList<>(Arrays.asList(list.get(to - 1)));
            for (int i = 0; i < quantity; i++) {
                String crate = listFrom.remove(size - 1 - i);
                listTo.add(crate);
            }
            list.set(from - 1, listFrom.toArray(new String[0]));
            list.set(to - 1, listTo.toArray(new String[0]));

            value = reader.readLine();
        }
        System.out.println(deepToString(list.toArray()));
        String result = "";
        for (String[] strings : list) {
            result += strings[strings.length - 1];
        }
        System.out.println("The rearrangement finish as: " + result);
    }

    private static void partTwo(String file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));

        ArrayList<String[]> list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            list.add((reader.readLine().split(" ")));
        }
        System.out.println(deepToString(list.toArray()));

        String value = reader.readLine();
        while (value != null) {
            String[] movement = value.split(" ");
            int quantity = Integer.parseInt(movement[1]);
            int from = Integer.parseInt(movement[3]);
            int to = Integer.parseInt(movement[5]);

            int size = list.get(from - 1).length;
            List<String> listFrom = new ArrayList<>(Arrays.asList(list.get(from - 1)));
            List<String> listTo = new ArrayList<>(Arrays.asList(list.get(to - 1)));
            List<String> listToCopy = new ArrayList<>();
            for (int i = 0; i < quantity; i++) {
                String crate = listFrom.remove(size - 1 - i);
                listToCopy.add(crate);
            }
            Collections.reverse(listToCopy);
            listTo.addAll(listToCopy);
            list.set(from - 1, listFrom.toArray(new String[0]));
            list.set(to - 1, listTo.toArray(new String[0]));

            value = reader.readLine();
        }
        System.out.println(deepToString(list.toArray()));
        String result = "";
        for (String[] strings : list) {
            result += strings[strings.length - 1];
        }
        System.out.println("The rearrangement finish as: " + result);
    }
}
