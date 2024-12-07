package BFS;

import DFS.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class RightSideView {

    /**
     * TC: 67.48%
     * SC: 34.73%
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root == null) {
            return result;
        }
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode tempNode = queue.peek();
            while (size > 0) {
                tempNode = queue.remove();
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
                size--;
            }
            result.add(tempNode.val);
        }
        return result;
    }
}
