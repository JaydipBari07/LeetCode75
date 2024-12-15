package bfs;

import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class MazeExit {

    int yLim, xLim;

    /**
     * TC: 18.42%
     * SC: 52.57%
     */
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<Pair<Integer, Integer>> queue = new ArrayDeque<>();
        queue.add(new Pair<>(entrance[0], entrance[1]));
        yLim = maze.length;
        xLim = maze[0].length;
        int totalSteps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int i = 0;
            while (i < size) {
                Pair<Integer, Integer> curPosition = queue.remove();
                if (hasReachedExit(curPosition, entrance)) {
                    return totalSteps;
                }
                Pair<Integer, Integer> up = new Pair<>(curPosition.getKey() - 1, curPosition.getValue());
                Pair<Integer, Integer> down = new Pair<>(curPosition.getKey() + 1, curPosition.getValue());
                Pair<Integer, Integer> left = new Pair<>(curPosition.getKey(), curPosition.getValue() - 1);
                Pair<Integer, Integer> right = new Pair<>(curPosition.getKey(), curPosition.getValue() + 1);
                if (isValidMove(left, maze)) {
                    queue.add(left);
                    maze[left.getKey()][left.getValue()] = '+';
                }
                if (isValidMove(right, maze)) {
                    queue.add(right);
                    maze[right.getKey()][right.getValue()] = '+';
                }
                if (isValidMove(up, maze)) {
                    queue.add(up);
                    maze[up.getKey()][up.getValue()] = '+';
                }
                if (isValidMove(down, maze)) {
                    queue.add(down);
                    maze[down.getKey()][down.getValue()] = '+';
                }
                i++;
            }
            totalSteps++;
        }
        return -1;
    }

    public boolean isValidMove(Pair<Integer, Integer> move, char[][] maze) {
        return move.getKey() >= 0 && move.getValue() >= 0 && move.getKey() < yLim && move.getValue() < xLim && maze[move.getKey()][move.getValue()] == '.';
    }

    public boolean hasReachedExit(Pair<Integer, Integer> move, int[] initialPosition) {
        return (move.getKey() == 0 || move.getValue() == 0 || move.getKey() == yLim-1 || move.getValue() == xLim-1) && (move.getKey() != initialPosition[0] || move.getValue() != initialPosition[1]);
    }
}
