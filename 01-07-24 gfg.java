class Solution {
    public TreeNode convert(Node head, TreeNode node) {
        if (head == null) {
            return null;
        }
        node = new TreeNode(head.data);
        head = head.next;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(node);
        while (head != null) {
            TreeNode parent = q.poll();
            TreeNode leftChild = null, rightChild = null;

            leftChild = new TreeNode(head.data);
            head = head.next;

            if (head != null) {
                rightChild = new TreeNode(head.data);
                head = head.next;
            }
            parent.left = leftChild;
            parent.right = rightChild;

            if (leftChild != null) q.offer(leftChild);
            if (rightChild != null) q.offer(rightChild);
        }
        return node;
    }
    public TreeNode linkedListToBinaryTree(Node head) {
        return convert(head, null);
    }
}
