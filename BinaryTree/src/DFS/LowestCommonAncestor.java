package DFS;

import java.util.*;

public class LowestCommonAncestor {

    List<Integer> elements = new ArrayList<>();
    TreeNode commonAncestor;

    /**
     * TC: 5.65%
     * SC: 5.35%
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        searchNodePath(root, p);
        if (searchNode2(root, q) && commonAncestor == null) {
            commonAncestor = root;
        }
        return commonAncestor;
    }

    /**
     * TC: 65.83%
     * SC: 16.69%
     */
    public TreeNode approach2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = approach2(root.left, p, q);
        TreeNode right = approach2(root.right, p, q);

        if (right == null) {
            return left;
        } else {
            if (left == null) {
                return right;
            } else {
                return root;
            }
        }
    }

    public boolean searchNodePath(TreeNode root, TreeNode node) {
        if (root == null) {
            return false;
        }
        elements.add(root.val);
        if (node.val == root.val) {
            return true;
        } else {
            if (!searchNodePath(root.left, node) && !searchNodePath(root.right, node)) {
                elements.remove(elements.size() - 1);
                return false;
            } else {
                return true;
            }
        }
    }

    public boolean searchNode2(TreeNode root, TreeNode node) {
        if (root == null) {
            return false;
        }
        if (root.val == node.val) {
            if (commonAncestor == null && elements.contains(root.val)) {
                commonAncestor = root;
            }
            return true;
        }
        if (searchNode2(root.left, node) || searchNode2(root.right, node)) {
            if (commonAncestor == null && elements.contains(root.val)) {
                commonAncestor = root;
            }
            return true;
        } else {
            return false;
        }
    }
}
