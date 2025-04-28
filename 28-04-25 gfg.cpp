class Solution {
  public:
    unordered_map<Node*,int>dp;
    int solve(Node* root){
        if (!root) return 0;
        if (dp.find(root) != dp.end()){
            return dp[root];
        }
        int nottake = solve(root->left) + solve(root->right);
        int take = root->data;
        if (root->left){
            take += solve(root->left->left);
            take += solve(root->left->right);
        }
        if(root->right){
            take += solve(root->right->left);
            take += solve(root->right->right);
        }
        dp[root] = max(take,nottake);
        return dp[root];
    }
    int getMaxSum(Node *root) {
        if (root == NULL) return 0;
        return solve(root);
    }
};
