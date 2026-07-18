class Solution {
public:
    static const int MOD = 1000000007;
    int findWays(vector<vector<int>>& matrix, int k) {
        int n = matrix.size();
        int m = matrix[0].size();
        vector<vector<int>> apples(n + 1, vector<int>(m + 1, 0));
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                apples[i][j] = matrix[i][j]
                             + apples[i + 1][j]
                             + apples[i][j + 1]
                             - apples[i + 1][j + 1];
            }
        }
        vector<vector<int>> dp(n, vector<int>(m, 0));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = (apples[i][j] > 0);
            }
        }
        for (int pieces = 2; pieces <= k; pieces++) {
            vector<vector<int>> ndp(n, vector<int>(m, 0));
            vector<vector<int>> colSum(n + 1, vector<int>(m, 0));
            for (int j = 0; j < m; j++) {
                for (int i = n - 1; i >= 0; i--) {
                    colSum[i][j] = (colSum[i + 1][j] + dp[i][j]) % MOD;
                }
            }
            vector<vector<int>> rowSum(n, vector<int>(m + 1, 0));
            for (int i = 0; i < n; i++) {
                for (int j = m - 1; j >= 0; j--) {
                    rowSum[i][j] = (rowSum[i][j + 1] + dp[i][j]) % MOD;
                }
            }
            for (int i = n - 1; i >= 0; i--) {
                for (int j = m - 1; j >= 0; j--) {
                    if (apples[i][j] == 0) continue;
                    long long ways = 0;
                    for (int x = i + 1; x < n; x++) {
                        if (apples[i][j] > apples[x][j]) {
                            ways += colSum[x][j];
                            break;
                        }
                    }
                    for (int y = j + 1; y < m; y++) {
                        if (apples[i][j] > apples[i][y]) {
                            ways += rowSum[i][y];
                            break;
                        }
                    }
                    ndp[i][j] = ways % MOD;
                }
            }
            dp.swap(ndp);
        }
        return dp[0][0];
    }
};
