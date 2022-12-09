package model.day07;

import java.util.ArrayList;
import java.util.List;

public class Directory {
    private final String name;
    private final List<Directory> directoriesChildren = new ArrayList<>();
    private final List<File> filesChildren = new ArrayList<>();
    private Directory parent = null;

    public Directory(String name) {
        this.name = name;
    }

    public void createDirectory(String name) {
        Directory directory = new Directory(name);
        directory.setParent(this);
        directoriesChildren.add(directory);
    }

    public void createFile(int size, String name) {
        File file = new File(size, name);
        file.setParent(this);
        filesChildren.add(file);
    }

    public int getSize() {
        int size = 0;
        for (File file : filesChildren) size += file.getSize();
        for (Directory directory : directoriesChildren) size += directory.getSize();
        return size;
    }

    public Directory getChildDirectory(String name) {
        for (Directory directory : directoriesChildren) {
            if (directory.getName().equals(name)) return directory;
        }
        return null;
    }

    public Directory getParent() {
        return parent;
    }

    public void setParent(Directory parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public List<Directory> getDirectoriesChildren() {
        return directoriesChildren;
    }
}
