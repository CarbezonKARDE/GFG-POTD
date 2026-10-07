class Solution {
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(Node root) {
        if (root == null) return -1;
        int[] leafCount = new int[1];
        dfs(root, leafCount);
        return leafCount[0] < 2 ? -1 : ans;
    }
    private int dfs(Node root, int[] leafCount) {
        if (root == null) return Integer.MIN_VALUE;
        if (root.left == null && root.right == null) {
            leafCount[0]++;
            return root.data;
        }
        int left = dfs(root.left, leafCount);
        int right = dfs(root.right, leafCount);
        if (root.left != null && root.right != null) {
            ans = Math.max(ans, left + root.data + right);
            return root.data + Math.max(left, right);
        }
        if (root.left != null) {
            return root.data + left;
        }
        return root.data + right;
    }
}
