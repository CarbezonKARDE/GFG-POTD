class Solution {
  public:
    void solve(Node* root, int hd, map<int, int>& mp) {
        if (!root) return;
        mp[hd] += root->data;
        solve(root->left, hd - 1, mp);
        solve(root->right, hd + 1, mp);
    }
    vector<int> verticalSum(Node* root) {
        map<int, int> mp;
        vector<int> ans;
        solve(root, 0, mp);
        for (auto it : mp) {
            ans.push_back(it.second);
        }
        return ans;
    }
};
