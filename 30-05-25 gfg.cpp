class Solution {
  public:
    int findMaxFork(Node* root, int k) {
        int ans = -1;
        while (root != nullptr) {
            if (root->data == k) {
                return k;
            } else if (root->data < k) {
                ans = root->data;
                root = root->right;
            } else {
                root = root->left;
            }
        }
        return ans;
    }
};
