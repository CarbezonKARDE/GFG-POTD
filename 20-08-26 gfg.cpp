class Solution {
  public:
    int maxDiff(Node* root) {
        int ans = INT_MIN;
        function<int(Node*)> dfs = [&](Node* node) -> int {
            if (!node)
                return INT_MAX;
            if (!node->left && !node->right)
                return node->data;
            int leftMin = dfs(node->left);
            int rightMin = dfs(node->right);
            int minDescendant = min(leftMin, rightMin);
            ans = max(ans, node->data - minDescendant);
            return min(node->data, minDescendant);
        };
        dfs(root);
        return ans;
    }
};
