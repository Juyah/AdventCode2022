package model.day12;

import java.util.List;

public class Node {
    public int row;
    public int column;

    public Node(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public List<Node> getNeighbours() {
        return List.of(getNorthNeighbour(), getEastNeighbour(), getSouthNeighbour(), getWestNeighbour());
    }


    public Node getNorthNeighbour() {
        return new Node(row - 1, column);
    }

    public Node getEastNeighbour() {
        return new Node(row, column + 1);
    }

    public Node getSouthNeighbour() {
        return new Node(row + 1, column);
    }

    public Node getWestNeighbour() {
        return new Node(row, column - 1);
    }

    @Override
    public String toString() {
        return "(" + "rowX=" + row + ", columnY=" + column + ')';
    }
}
