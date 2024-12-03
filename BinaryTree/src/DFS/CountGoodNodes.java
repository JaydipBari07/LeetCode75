package DFS;

public class CountGoodNodes {

    int goodNodesCount = 0;

    /**
     * TC: 85.14%
     * SC: 44.97%
     */
    public int goodNodes(TreeNode root) {
        traverseTree(root, root.val);
        return goodNodesCount;
    }

    public void traverseTree(TreeNode node, int prevMax) {
        if (node == null) {
            return;
        }
        if (node.val >= prevMax) {
            goodNodesCount += 1;
        }
        if (node.left == null && node.right == null) {
            return;
        }
        if (node.left != null) {
            traverseTree(node.left, Math.max(node.val, prevMax));
        }
        if(node.right != null){
            traverseTree(node.right, Math.max(node.val, prevMax));
        }
    }
}
