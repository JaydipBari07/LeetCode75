package DFS;

import java.util.ArrayDeque;
import java.util.Queue;

public class LeafSimilarTrees {

    Queue<Integer> queue = new ArrayDeque<>();

    /**
     * TC: 100%
     * SC: 82.11%
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        visitLeafNodes(root1, true);
        return visitLeafNodes(root2, false) && queue.isEmpty();
    }

    public boolean visitLeafNodes(TreeNode root, boolean appendQueue) {
        if (root.left == null && root.right == null) {
            if (appendQueue) {
                queue.add(root.val);
            } else {
                if (queue.isEmpty()) {
                    return false;
                } else {
                    return queue.remove() == root.val;
                }
            }
        } else {
            if (root.left != null) {
                if (!visitLeafNodes(root.left, appendQueue)) {
                    return false;
                }
            }
            if (root.right != null) {
                if (!visitLeafNodes(root.right, appendQueue)) {
                    return false;
                }
            }
        }
        return true;
    }
}
