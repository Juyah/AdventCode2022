package model.day07;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day07 {

    public static void main(String[] args) throws IOException {
        String file = "src/inputs/day07.txt";
        partOne(file);
    }

    private static void partOne(String file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));


        String value = reader.readLine();
        Directory root = new Directory("/");
        Directory cwd = root;

        value = reader.readLine();
        while (value != null) {
            String[] terminalOutput = value.split(" ");

            if (terminalOutput[0].equals("$")) {
                if (terminalOutput[1].equals("cd")) {
                    if (terminalOutput[2].equals("/")) {
                        cwd = root;
                    } else if (terminalOutput[2].equals("..")) {
                        cwd = cwd.getParent();
                    } else {
                        cwd = cwd.getChildDirectory(terminalOutput[2]);
                    }
                }
            } else if (terminalOutput[0].equals("dir")) {
                cwd.createDirectory(terminalOutput[1]);
            } else {
                cwd.createFile(Integer.parseInt(terminalOutput[0]), terminalOutput[1]);
            }
            value = reader.readLine();
        }
        printDirectories(root);
        int totalSize = sumDirectoriesLessThan(root, 100000);
        System.out.println("Total size: " + totalSize);
        int sizeDirectoryToDelete = getSmallestDirectoryToDelete(root, 30000000 - (70000000 - root.getSize()));
        System.out.println("Size of directory to delete: " + sizeDirectoryToDelete);
    }

    private static void printDirectories(Directory directory) {
        System.out.printf("Directory: %s - %dkB%n", directory.getName(), directory.getSize());
        for (Directory child : directory.getDirectoriesChildren()) {
            printDirectories(child);
        }
    }

    private static int sumDirectoriesLessThan(Directory directory, int size) {
        int sum = 0;
        if (directory.getSize() < size) {
            sum += directory.getSize();
        }
        for (Directory child : directory.getDirectoriesChildren()) {
            sum += sumDirectoriesLessThan(child, size);
        }
        return sum;
    }

    private static int getSmallestDirectoryToDelete(Directory directory, int size) {
        int smallest = 0;
        if (directory.getSize() >= size) {
            smallest = directory.getSize();
        }
        for (Directory child : directory.getDirectoriesChildren()) {
            int childSmallest = getSmallestDirectoryToDelete(child, size);
            if (childSmallest < smallest && childSmallest >= size) {
                smallest = childSmallest;
            }
        }
        return smallest;
    }
}
