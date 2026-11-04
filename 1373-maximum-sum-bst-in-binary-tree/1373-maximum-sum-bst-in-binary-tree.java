class Quad {
    int max;
    int min;
    int sum;
    boolean isBST;

    Quad(int max, int min, int sum, boolean isBST) {
        this.max = max;
        this.min = min;
        this.sum = sum;
        this.isBST = isBST;
    }
}

class Solution {
    int maxSum = 0;

    public Quad solve(TreeNode root) {

        if (root == null) {
            return new Quad(
                Integer.MIN_VALUE,
                Integer.MAX_VALUE,
                0,
                true
            );
        }

        Quad left = solve(root.left);
        Quad right = solve(root.right);

        if (left.isBST && right.isBST &&
            root.val > left.max &&
            root.val < right.min) {

            int sum = left.sum + right.sum + root.val;

            maxSum = Math.max(maxSum, sum);

            return new Quad(
                Math.max(root.val, right.max),
                Math.min(root.val, left.min),
                sum,
                true
            );
        }

        return new Quad(0, 0, 0, false);
    }

    public int maxSumBST(TreeNode root) {
        solve(root);
        return maxSum;
    }
}