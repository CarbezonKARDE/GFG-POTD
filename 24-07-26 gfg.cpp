class Solution {
  public:
    int ans = 1;
    void dfs(Node* node, int prev, int len) {
        if (!node) return;
        if (node->data == prev + 1)
            len++;
        else
            len = 1;
        ans = max(ans, len);
        dfs(node->left, node->data, len);
        dfs(node->right, node->data, len);
    }
    int longestConsecutive(Node* root) {
        if (!root) return -1;
        dfs(root, root->data - 1, 0);
        return (ans == 1) ? -1 : ans;
    }
};
