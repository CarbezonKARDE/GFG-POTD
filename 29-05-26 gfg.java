class Solution {
    private long[][] dp;
    private String s;
    private int n;
    private long solve(int idx, int prevSum) {
        if (idx == n) return 1;
        if (dp[idx][prevSum] != -1)
            return dp[idx][prevSum];
        long ways = 0;
        int currSum = 0;
        for (int i = idx; i < n; i++) {
            currSum += s.charAt(i) - '0';
            if (currSum >= prevSum) {
                ways += solve(i + 1, currSum);
            }
        }
        return dp[idx][prevSum] = ways;
    }
    public int validGroups(String s) {
        this.s = s;
        this.n = s.length();
        dp = new long[n + 1][901];
        for (int i = 0; i <= n; i++) {
            java.util.Arrays.fill(dp[i], -1);
        }
        return (int) solve(0, 0);
    }
}
