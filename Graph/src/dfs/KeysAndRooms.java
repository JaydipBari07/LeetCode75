package dfs;

import java.util.*;

public class KeysAndRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
//        return approach1(rooms);
        int[] visited = new int[rooms.size()];
        approach2(rooms, visited, 0);
        return Arrays.stream(visited).allMatch(val -> val == 1);
    }

    /**
     * TC: 57.06%
     * SC: 8.72%
     */
    public void approach2(List<List<Integer>> rooms, int[] visited, int room) {
        visited[room] = 1;
        for (int roomKey : rooms.get(room)) {
            if (visited[roomKey] == 0) {
                approach2(rooms, visited, roomKey);
            }
        }
    }

    /**
     * TC: 5.01%
     * SC: 43.88%
     */
    public boolean approach1(List<List<Integer>> rooms) {
        int totalRooms = rooms.size();
        int[] keys = new int[totalRooms];
        int cur = 0;
        keys[0] = 1;
        List<Integer> visitList = new ArrayList<>();
        visitList.add(0);
        while (cur < visitList.size()) {
            for (Integer key : rooms.get(visitList.get(cur))) {
                if (keys[key] == 0) {
                    visitList.add(key);
                    keys[key] = 1;
                }
            }
            cur++;
        }
        return totalRooms == visitList.size();
    }
}
