class Solution {
public:
    string matrixChainOrder(vector<int> &arr) {
        int n = arr.size();
        int m = n - 1;
        vector<vector<long long>> dp(m, vector<long long>(m, 0));
        vector<vector<int>> bracket(m, vector<int>(m, -1));
        for (int L = 2; L <= m; L++) {
            for (int i = 0; i + L - 1 < m; i++) {
                int j = i + L - 1;
                dp[i][j] = LLONG_MAX;

                for (int k = i; k < j; k++) {
                    long long cost = dp[i][k] + dp[k+1][j] +
                                     1LL * arr[i] * arr[k+1] * arr[j+1];
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                        bracket[i][j] = k;
                    }
                }
            }
        }
        return buildString(0, m - 1, bracket);
    }
    string buildString(int i, int j, vector<vector<int>>& bracket) {
        if (i == j) {
            char name = 'A' + i;
            return string(1, name);
        }
        int k = bracket[i][j];
        return "(" + buildString(i, k, bracket) + buildString(k + 1, j, bracket) + ")";
    }
};
