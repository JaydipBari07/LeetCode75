import java.util.Stack;

public class NumberOfProvinces {

    public int provinces = 0;

    /**
     * TC: 90.36%
     * SC: 23.95%
     */
    public int findCircleNum(int[][] isConnected) {
        int[] visited = new int[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i] == 0) {
                provinces++;
                dfs(isConnected, visited, i);
            }
        }
        return provinces;
    }

    public void dfs(int[][] isConnected, int[] visited, int curCity) {
        if (visited[curCity] == 0) {
            visited[curCity] = 1;
            for (int i = 0; i < isConnected.length; i++) {
                if (i != curCity && visited[i] == 0 && isConnected[curCity][i] == 1) {
                    dfs(isConnected, visited, i);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] isConnected = new int[][]{{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}};
        System.out.println(new NumberOfProvinces().findCircleNum(isConnected));
    }
}
