class Solution {
    int maxSum;
    int helper(Node root) {
        if (root == null) return 0;
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        maxSum = Math.max(maxSum, left + right + root.data);
        return root.data + Math.max(left, right);
    }
    int findMaxSum(Node root) {
        maxSum = Integer.MIN_VALUE;
        helper(root);
        return maxSum;
    }
}
