package BFS;

import DFS.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaxLevelSum {

    /**
     * TC: 90.07%
     * SC: 5.44%
     */
    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxSum = root.val, curLevel = 1, maxSumLevel = 1;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;
            while (size > 0) {
                TreeNode temp = queue.remove();
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
                sum += temp.val;
                size--;
            }
            if (sum > maxSum) {
                maxSumLevel = curLevel;
                maxSum = sum;
            }
            curLevel++;
        }
        return maxSumLevel;
    }
}
