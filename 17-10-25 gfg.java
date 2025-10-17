class Solution {
    static int sum;
    public static void transformTree(Node root) {
        sum = 0;
        transform(root);
    }
    private static void transform(Node root) {
        if (root == null) return;
        transform(root.right);
        int original = root.data;
        root.data = sum;
        sum += original;
        transform(root.left);
    }
}
