class Solution {
    static class TrieNode {
        TrieNode[] child = new TrieNode[2];
    }
    private void insert(TrieNode root, int num) {
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (root.child[bit] == null) {
                root.child[bit] = new TrieNode();
            }
            root = root.child[bit];
        }
    }
    private int getMaxXor(TrieNode root, int num) {
        int maxXor = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (root.child[1 - bit] != null) {
                maxXor |= (1 << i);
                root = root.child[1 - bit];
            } else {
                root = root.child[bit];
            }
        }
        return maxXor;
    }
    public int maxXor(int[] arr) {
        TrieNode root = new TrieNode();
        int max = 0;
        insert(root, arr[0]);
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, getMaxXor(root, arr[i]));
            insert(root, arr[i]);
        }
        return max;
    }
}
