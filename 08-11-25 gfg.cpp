class Solution {
  public:
    int numberOfPath(vector<vector<int>>& mat, int k) {
        int n = mat.size(), m = mat[0].size();
        vector<vector<vector<int>>> dp(n, vector<vector<int>>(m, vector<int>(k+1, 0)));
        if (mat[0][0] <= k) dp[0][0][mat[0][0]] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int s = 0; s <= k; s++) {
                    if (dp[i][j][s] == 0) continue;
                    if (i + 1 < n && s + mat[i+1][j] <= k) {
                        dp[i+1][j][s + mat[i+1][j]] += dp[i][j][s];
                    }
                    if (j + 1 < m && s + mat[i][j+1] <= k) {
                        dp[i][j+1][s + mat[i][j+1]] += dp[i][j][s];
                    }
                }
            }
        }
        return dp[n-1][m-1][k];
    }
};
