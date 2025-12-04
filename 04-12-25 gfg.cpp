class Solution {
public:
    int minCost(vector<int> &keys, vector<int> &freq) {
        int n = keys.size();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        vector<int> prefix(n+1, 0);
        for(int i = 0; i < n; i++) 
            prefix[i+1] = prefix[i] + freq[i];
        auto sum = [&](int l, int r) {
            return prefix[r+1] - prefix[l];
        };
        for(int i = 0; i < n; i++)
            dp[i][i] = freq[i];
        for(int len = 2; len <= n; len++) {
            for(int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                dp[i][j] = INT_MAX;
                for(int r = i; r <= j; r++) {
                    int left  = (r > i) ? dp[i][r-1] : 0;
                    int right = (r < j) ? dp[r+1][j] : 0;

                    dp[i][j] = min(dp[i][j], left + right + sum(i, j));
                }
            }
        }
        return dp[0][n-1];
    }
};
