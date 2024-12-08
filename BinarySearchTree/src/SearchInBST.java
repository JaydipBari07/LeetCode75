public class SearchInBST {

    /**
     * TC: 100.00%
     * SC: 49.49%
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        return val > root.val ? searchBST(root.right, val) : searchBST(root.left, val);
    }
}
