class Solution {
    static int calc(int prices[], int k, boolean has, int i, int[][][] dp) {
        if(i >= prices.length || k <= 0) {
            return 0;
        }
        int hasIdx = has ? 1 : 0;
        if(dp[i][k][hasIdx] != -1) {
            return dp[i][k][hasIdx];
        }
        int pick = 0;
        int notPick = calc(prices, k, has, i+1, dp);
        if(has) {
            pick = prices[i] + calc(prices, k-1, false, i+1, dp);
        } else {
            pick = -prices[i] + calc(prices, k, true, i+1, dp);
        }
        return dp[i][k][hasIdx] = Math.max(pick, notPick);
    }
    static int maxProfit(int prices[], int k) {
        int n = prices.length;
        int[][][] dp = new int[n][k+1][2];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= k; j++) {
                dp[i][j][0] = dp[i][j][1] = -1;
            }
        }
        return calc(prices, k, false, 0, dp);
    }
}
