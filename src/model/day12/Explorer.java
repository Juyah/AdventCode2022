package model.day12;

import java.util.LinkedList;
import java.util.Queue;

public class Explorer {

    public Matrix matrix;
    public Node start;

    public Queue<Node> explorationQueue;

    public int[][] distances;

    public Explorer(Matrix matrix, Node start) {
        this.matrix = matrix;
        this.start = start;
        this.distances = new int[matrix.rows()][matrix.columns()];
        for (int i = 0; i < matrix.rows(); i++) {
            for (int j = 0; j < matrix.columns(); j++) {
                this.distances[i][j] = -1;
            }
        }
        this.distances[start.row][start.column] = 0;
        this.explorationQueue = new LinkedList<>();
        this.explorationQueue.add(start);
    }

    public boolean isExploring() {
        return !explorationQueue.isEmpty();
    }

    public Node explore() {
        Node exploring = explorationQueue.remove();
        int distance = distances[exploring.row][exploring.column];
        for (Node neighbor : matrix.findNeighbors(exploring)) {
            if (distances[neighbor.row][neighbor.column] == -1) {
                distances[neighbor.row][neighbor.column] = distance + 1;
                explorationQueue.add(neighbor);
            }
        }
        return exploring;
    }
}
