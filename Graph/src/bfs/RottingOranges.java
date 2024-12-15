package bfs;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class RottingOranges {

    /**
     * TC: 71.80%
     * SC: 80.58%
     */
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int rn = grid.length;
        int cn = grid[0].length;
        int count = 0;
        List<Pair<Integer, Integer>> queue = new ArrayList<>();
        for (int i = 0; i < rn; i++) {
            for (int j = 0; j < cn; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pair<>(i, j));
                }
            }
        }

        int[][] neighbors = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Pair<Integer, Integer> pair = queue.remove(0);
                int r = pair.getKey();
                int c = pair.getValue();

                for (int[] neighbor : neighbors) {
                    int newR = r + neighbor[0];
                    int newC = c + neighbor[1];
                    if (newR == rn || newC == cn || newR < 0 || newC < 0 || grid[newR][newC] != 1) {
                        continue;
                    }
                    queue.add(new Pair<>(newR, newC));
                    grid[newR][newC] = 2;
                }
            }
            if(!queue.isEmpty())
                count += 1;
        }
        for (int i = 0; i < rn; i++) {
            for (int j = 0; j < cn; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return count;
    }
}
