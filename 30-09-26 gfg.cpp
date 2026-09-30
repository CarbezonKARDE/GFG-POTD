class Solution {
public:
    int ways(int x, int y) {
        const long long MOD = 1000000007;
        int n = x + y;
        vector<long long> dp(x + 1, 0);
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = min(i, x); j >= 1; j--) {
                dp[j] = (dp[j] + dp[j - 1]) % MOD;
            }
        }
        return dp[x];
    }
};
