class Solution {
    public int tsp(int[][] cost) {
        int n = cost.length;
        int fullMask = (1 << n);
        int[][] dp = new int[fullMask][n];
        for (int i = 0; i < fullMask; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return solve(1, 0, cost, dp, n);
    }
    private int solve(int mask, int pos, int[][] cost, int[][] dp, int n) {
        if (mask == (1 << n) - 1) {
            return cost[pos][0];
        }
        if (dp[mask][pos] != -1) return dp[mask][pos];
        int ans = Integer.MAX_VALUE;
        for (int next = 0; next < n; next++) {
            if ((mask & (1 << next)) == 0) {
                int newMask = mask | (1 << next);
                int res = cost[pos][next] + solve(newMask, next, cost, dp, n);
                ans = Math.min(ans, res);
            }
        }
        return dp[mask][pos] = ans;
    }
}
