class Solution {
    HashMap<Integer, Integer> pos = new HashMap<>();
    int[] pre, preMirror;
    public Node constructBinaryTree(int[] pre, int[] preMirror) {
        this.pre = pre;
        this.preMirror = preMirror;
        for (int i = 0; i < preMirror.length; i++) {
            pos.put(preMirror[i], i);
        }
        return build(0, pre.length - 1, 0, preMirror.length - 1);
    }
    private Node build(int preL, int preR, int mirL, int mirR) {
        if (preL > preR) return null;
        Node root = new Node(pre[preL]);
        if (preL == preR) return root;
        int leftRoot = pre[preL + 1];
        int idx = pos.get(leftRoot);
        int leftSize = mirR - idx + 1;
        root.left = build(preL + 1, preL + leftSize, idx, mirR);
        root.right = build(preL + leftSize + 1, preR, mirL + 1, idx - 1);
        return root;
    }
}
