package model.day12;

import java.util.List;

public class Matrix {
    public int[][] matrix;
    public boolean part1 = true;

    public Matrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public List<Node> findNeighbors(Node center) {
        return center.getNeighbours().stream().filter(neighbor -> this.canMove(center, neighbor)).toList();
    }

    public boolean isOutside(Node node) {
        int rowX = node.row;
        int columnY = node.column;

        return rowX < 0 || rowX >= rows() || columnY < 0 || columnY >= columns();
    }

    public boolean canMove(Node from, Node to) {
        if (isOutside(from) || isOutside(to))
            return false;
        int heightFrom = matrix[from.row][from.column];
        int heightTo = matrix[to.row][to.column];
        if (part1) {
            return heightFrom + 1 >= heightTo;
        }
        return heightTo + 1 >= heightFrom;
    }

    public int rows() {
        return matrix.length;
    }

    public int columns() {
        return matrix[0].length;
    }
}
