class Solution {
  public:
    vector<int> zigZagTraversal(Node* root) {
        vector<int> ans;
        if (!root) return ans;
        queue<Node*> q;
        q.push(root);
        bool leftToRight = true;

        while (!q.empty()) {
            int size = q.size();
            vector<int> level;
            for (int i = 0; i < size; i++) {
                Node* node = q.front();
                q.pop();
                level.push_back(node->data);
                if (node->left) q.push(node->left);
                if (node->right) q.push(node->right);
            }
            if (!leftToRight)
                reverse(level.begin(), level.end());
            ans.insert(ans.end(), level.begin(), level.end());
            leftToRight = !leftToRight;
        }
        return ans;
    }
};
