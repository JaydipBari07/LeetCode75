package DFS;

public class MaximumDepth {

    /**
     * TC: 100%
     * SC: 6.84%
     */
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if (root.right == null && root.left == null) {
            return 1;
        }
        if(root.left != null && root.right != null){
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        } else if(root.left != null){
            return maxDepth(root.left) + 1;
        } else {
            return maxDepth(root.right) + 1;
        }
    }
}
