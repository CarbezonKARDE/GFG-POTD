class Solution {
    static class TrieNode {
        TrieNode[] child = new TrieNode[2];
        int count = 0;
    }
    TrieNode root = new TrieNode();
    static final int MAX_BIT = 15;
    private int query(TrieNode root, int num, int k) {
        TrieNode curr = root;
        int total = 0;
        for (int bit = MAX_BIT; bit >= 0; bit--) {
            if (curr == null) break;
            int x = (num >> bit) & 1;
            int kb = (k >> bit) & 1;
            if (kb == 1) {
                if (curr.child[x] != null)
                    total += curr.child[x].count;
                curr = curr.child[x ^ 1];
            } 
            else {
                curr = curr.child[x];
            }
        }
        return total;
    }
    private void insert(TrieNode root, int num) {
        TrieNode curr = root;
        for (int bit = MAX_BIT; bit >= 0; bit--) {
            int x = (num >> bit) & 1;
            if (curr.child[x] == null)
                curr.child[x] = new TrieNode();
            curr = curr.child[x];
            curr.count++;
        }
    }
    public int cntPairs(int[] arr, int k) {
        int result = 0;
        for (int num : arr) {
            result += query(root, num, k);
            insert(root, num);
        }
        return result;
    }
}
