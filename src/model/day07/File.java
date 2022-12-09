package model.day07;

public class File {
    private Directory parent;
    private int size;
    private String name;

    public File(int size, String name) {
        this.size = size;
        this.name = name;
    }

    public void setParent(Directory parent) {
        this.parent = parent;
    }

    public int getSize() {
        return size;
    }
}
