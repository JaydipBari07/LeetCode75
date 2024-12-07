package DFS;

public class LongestZigZagPath {

    int maxCount = 0;

    /**
     * TC: 95.83%
     * SC: 84.46%
     * isRight = tells whether last move was right. 1 means Yes, 0 means No.
     */
    public int longestZigZag(TreeNode root) {
        traverseZigZag(root, 0, 1);
        return maxCount;
    }

    public void traverseZigZag(TreeNode node, int count, int isRight) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            maxCount = Math.max(count, maxCount);
            return;
        }
        if (isRight == 1) {
            if (node.left == null) {
                maxCount = Math.max(count, maxCount);
            } else {
                traverseZigZag(node.left, count + 1, 0);
            }
            if (node.right != null) {
                traverseZigZag(node.right, 1, 1);
            }
        } else {
            if (node.right == null) {
                maxCount = Math.max(count, maxCount);
            } else {
                traverseZigZag(node.right, count + 1, 1);
            }
            if (node.left != null) {
                traverseZigZag(node.left, 1, 0);
            }
        }
    }
}
