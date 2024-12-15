package dfs;

import javafx.util.Pair;

import java.util.*;

public class EvaluateDivision {

    double curDivision = -1;

    /**
     * TC: 31.63%
     * SC: 69.19%
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Pair<String, Double>>> relations = new HashMap<>();
        Set<String> variables = new HashSet<>();
        double[] result = new double[queries.size()];
        int i = 0;
        for (List<String> pair : equations) {
            relations.computeIfAbsent(pair.get(0), value -> new ArrayList<>()).add(new Pair<>(pair.get(1), values[i]));
            relations.computeIfAbsent(pair.get(1), value -> new ArrayList<>()).add(new Pair<>(pair.get(0), 1 / values[i]));
            variables.add(pair.get(0));
            variables.add(pair.get(1));
            i++;
        }

        i = 0;
        for (List<String> query : queries) {
            curDivision = -1;
            if (variables.contains(query.get(0)) && variables.contains(query.get(1))) {
                if (query.get(0).equals(query.get(1))) {
                    result[i] = 1.0;
                    i++;
                    continue;
                } else {
                    List<String> visited = new ArrayList<>();
                    visited.add(query.get(0));
                    dfs(relations, 1.0, "", query.get(0), query.get(1), visited);
                }
            }
            result[i] = curDivision;
            i++;
        }
        return result;
    }

    public boolean dfs(Map<String, List<Pair<String, Double>>> relations, double division, String prevNode, String curNode, String destNode, List<String> visited) {
        if (!relations.containsKey(curNode)) {
            return false;
        }
        boolean changed = false;
        for (Pair<String, Double> pair : relations.get(curNode)) {
            String key = pair.getKey();
            double value = pair.getValue();
            if (visited.contains(key)) {
                continue;
            }
            visited.add(key);
            changed = true;
            division *= value;
            if (key.equals(destNode)) {
                curDivision = division;
                return true;
            }
            if (dfs(relations, division, curNode, key, destNode, visited)) {
                return true;
            } else {
                visited.remove(visited.size() - 1);
                division /= value;
                changed = false;
            }
        }
        return changed;
    }
}
