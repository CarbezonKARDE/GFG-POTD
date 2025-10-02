class Solution {
public:
    vector<vector<int>> ans;
    void backtrack(int n, int k, int start, vector<int>& curr, int sum) {
        if (curr.size() == k) {
            if (sum == n) ans.push_back(curr);
            return;
        }
        for (int i = start; i <= 9; i++) {
            if (sum + i > n) break;
            curr.push_back(i);
            backtrack(n, k, i + 1, curr, sum + i);
            curr.pop_back();
        }
    }
    vector<vector<int>> combinationSum(int n, int k) {
        vector<int> curr;
        backtrack(n, k, 1, curr, 0);
        return ans;
    }
};
