package DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PathSum3 {

    int count = 0;
    Map<Long, Integer> map = new HashMap<>();

    public int pathSum(TreeNode root, int targetSum) {
//        findPaths(root, new ArrayList<>(), targetSum, 0);
        scanTree(root, 0, targetSum);
        return count;
    }

    /**
     * TC: 96.11
     * SC: 12.23%
     */
    public void scanTree(TreeNode node, long curSum, int targetSum) {
        if (node == null) {
            return;
        }
        curSum += node.val;
        if (map.containsKey(curSum - targetSum)) {
            count += map.get(curSum - targetSum);
        }
        if (curSum == targetSum) {
            count++;
        }
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        scanTree(node.left, curSum, targetSum);
        scanTree(node.right, curSum, targetSum);
        map.put(curSum, map.get(curSum) - 1);
    }

    /**
     * TC: 8.06%
     * SC: 61.06%
     */
    public void findPaths(TreeNode root, List<Integer> list, int targetSum, long curSum) {
        if (root == null) {
            return;
        }
        curSum += root.val;
        list.add(root.val);
        long sum = curSum;
        int i = 0;
        if (sum == targetSum) {
            count++;
        }
        while (i < list.size()) {
            sum -= list.get(i);
            i++;
            if (i < list.size() && targetSum == sum) {
                count++;
            }
        }
        if (root.left == null && root.right == null) {
            list.remove(list.size() - 1);
            return;
        }
        if (root.left != null) {
            findPaths(root.left, list, targetSum, curSum);
        }
        if (root.right != null) {
            findPaths(root.right, list, targetSum, curSum);
        }
        list.remove(list.size() - 1);
    }
}
