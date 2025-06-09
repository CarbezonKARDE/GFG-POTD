class Solution {
    public boolean isDeadEnd(Node root) {
        return isDeadEndUtil(root, 1, Integer.MAX_VALUE);
    }
    private boolean isDeadEndUtil(Node node, int min, int max) {
        if (node == null) return false;
        if (min == max) return true;
        return isDeadEndUtil(node.left, min, node.data - 1) ||
               isDeadEndUtil(node.right, node.data + 1, max);
    }
}
