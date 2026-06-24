class Solution {
    bool dfs(int i, int j, vector<vector<int>>& mat,
             vector<vector<int>>& ans,
             vector<vector<int>>& dp, int n) {
        if (i == n - 1 && j == n - 1) {
            ans[i][j] = 1;
            return true;
        }
        if (mat[i][j] == 0) return false;
        if (dp[i][j] != -1)
            return dp[i][j];
        ans[i][j] = 1;
        int jump = mat[i][j];
        for (int step = 1; step <= jump; step++) {
            if (j + step < n) {
                if (dfs(i, j + step, mat, ans, dp, n)) {
                    return dp[i][j] = true;
                }
            }
            if (i + step < n) {
                if (dfs(i + step, j, mat, ans, dp, n)) {
                    return dp[i][j] = true;
                }
            }
        }
        ans[i][j] = 0;
        return dp[i][j] = false;
    }
public:
    vector<vector<int>> shortestDist(vector<vector<int>>& mat) {
        int n = mat.size();
        if (mat[0][0] == 0)
            return {{-1}};
        vector<vector<int>> ans(n, vector<int>(n, 0));
        vector<vector<int>> dp(n, vector<int>(n, -1));
        if (dfs(0, 0, mat, ans, dp, n))
            return ans;
        return {{-1}};
    }
};
