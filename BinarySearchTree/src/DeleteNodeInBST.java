public class DeleteNodeInBST {

    /**
     * TC: 100.00%
     * SC: 5.58%
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            } else {
                TreeNode minNode = findMin(root.right);
                root.val = minNode.val;
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
    }

    public TreeNode findMin(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            return findMin(root.left);
        } else {
            return root;
        }
    }
}
