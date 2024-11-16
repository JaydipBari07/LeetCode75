public class EqualRowAndColumn {

    /**
     * Approach 1
     * Time Complexity = Beats 67.61%
     * Space Complexity = Beats 91.07%
     */
    public int equalPairs(int[][] grid) {
        int n = grid.length, count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][0] == grid[0][j]) {
                    boolean matches = true;
                    for (int k = 1; k < n; k++) {
                        if (grid[i][k] != grid[k][j]) {
                            matches = false;
                            break;
                        }
                    }
                    if (matches) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        int[][] grid = new int[][]{{3, 2, 1}, {1, 7, 6}, {2, 7, 7}};
        int[][] grid = new int[][]{{3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}};
        System.out.println(new EqualRowAndColumn().equalPairs(grid));
    }
}
