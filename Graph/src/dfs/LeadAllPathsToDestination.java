package dfs;

import javafx.util.Pair;

import java.util.*;

public class LeadAllPathsToDestination {

    Map<Integer, List<Integer>> outgoingRoutes = new HashMap<>();
    Map<Integer, List<Integer>> incomingRoutes = new HashMap<>();
    Integer totalReorders = 0;
    boolean[] citiesVisited;

    /**
     * TC: 21.78%
     * SC: 92.93%
     */
    public int minReorderApproach2(int n, int[][] connections) {
        Map<Integer, List<Pair<Integer, Integer>>> relations = new HashMap<>();
        for (int[] path : connections) {
            relations.computeIfAbsent(path[0], curNode -> new ArrayList<>()).add(new Pair<>(path[1], 1));
            relations.computeIfAbsent(path[1], curNode -> new ArrayList<>()).add(new Pair<>(path[0], 0));
        }
        dfsApproach2(relations, 0, 0);
        return totalReorders;
    }

    public void dfsApproach2(Map<Integer, List<Pair<Integer, Integer>>> relations, int curNode, int prevNode) {
        if (!relations.containsKey(curNode)) {
            return;
        }
        for (Pair<Integer, Integer> pair : relations.get(curNode)) {
            if (pair.getKey() != prevNode) {
                totalReorders += pair.getValue();
                dfsApproach2(relations, pair.getKey(), curNode);
            }
        }
    }

    /**
     * TC: 38.87
     * SC: 95.46%
     */
    public int minReorderApproach1(int n, int[][] connections) {
        createIncomingRoutesMap(connections);
        createOutgoingRoutesMap(connections);
        //write logic to traverse like dfs and find total number of changes you have to do
        //No need to keep visited array because one city is visited only once as there is only one way that connects a city to another.
        citiesVisited = new boolean[n];
        dfsApproach1(0, 0);
        return totalReorders;
    }

    public void dfsApproach1(int currentCity, int prevCity) {
        if (citiesVisited[currentCity]) {
            return;
        }
        citiesVisited[currentCity] = true;
        if (outgoingRoutes.containsKey(currentCity)) {
            for (int nextCity : outgoingRoutes.get(currentCity)) {
                if (nextCity == prevCity) {
                    continue;
                }
                totalReorders++;
                dfsApproach1(nextCity, currentCity);
            }
        }
        if (incomingRoutes.containsKey(currentCity)) {
            for (int nextCity : incomingRoutes.get(currentCity)) {
                if (nextCity == prevCity) {
                    continue;
                }
                dfsApproach1(nextCity, currentCity);
            }
        }
    }

    public void createIncomingRoutesMap(int[][] connections) {
        for (int[] route : connections) {
            List<Integer> list = incomingRoutes.getOrDefault(route[1], new ArrayList<>());
            list.add(route[0]);
            incomingRoutes.put(route[1], list);
        }
    }

    public void createOutgoingRoutesMap(int[][] connections) {
        for (int[] route : connections) {
            List<Integer> list = outgoingRoutes.getOrDefault(route[0], new ArrayList<>());
            list.add(route[1]);
            outgoingRoutes.put(route[0], list);
        }
    }

    public static void main(String[] args) {
        int[][] connections = new int[][]{{1, 0}, {1, 2}, {3, 2}, {3, 4}};
//        int[][] connections = new int[][]{{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
        System.out.println(new LeadAllPathsToDestination().minReorderApproach2(6, connections));
//        System.out.println(new LeadAllPathsToDestination().);
    }
}
