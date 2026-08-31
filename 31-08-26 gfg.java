class Solution {
    public int minCost(int n, int i, int d, int c) {
        long[] dp = new long[n + 1];
        for (int x = 1; x <= n; x++) {
            dp[x] = dp[x - 1] + i;
            if (x % 2 == 0) {
                dp[x] = Math.min(dp[x], dp[x / 2] + c);
            } else if (x > 1) {
                dp[x] = Math.min(dp[x], dp[(x + 1) / 2] + c + d);
            }
        }
        return (int) dp[n];
    }
}
