class Solution {
    static class Info {
        int min, max, size;
        boolean isBST;

        Info(int min, int max, int size, boolean isBST) {
            this.min = min;
            this.max = max;
            this.size = size;
            this.isBST = isBST;
        }
    }
    static int maxBST = 0;
    static int largestBst(Node root) {
        maxBST = 0;
        solve(root);
        return maxBST;
    }
    static Info solve(Node root) {
        if (root == null) {
            return new Info(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);
        }
        Info left = solve(root.left);
        Info right = solve(root.right);
        if (left.isBST && right.isBST &&
            root.data > left.max && root.data < right.min) {
            int size = left.size + right.size + 1;
            maxBST = Math.max(maxBST, size);
            return new Info(
                Math.min(root.data, left.min),
                Math.max(root.data, right.max),
                size,
                true
            );
        }
        return new Info(Integer.MIN_VALUE, Integer.MAX_VALUE, 0, false);
    }
}
