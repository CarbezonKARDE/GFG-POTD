class Solution {
    public int findMinCost(String s1, String s2, int costS1, int costS2) {
        int n = s1.length();
        int m = s2.length();
        long[] dp = new long[m + 1];
        for (int i = 1; i <= n; i++) {
            long prev = 0;
            for (int j = 1; j <= m; j++) {
                long temp = dp[j];
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[j] = prev + costS1 + costS2;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                prev = temp;
            }
        }
        long totalCost = (long) n * costS1 + (long) m * costS2;
        return (int) (totalCost - dp[m]);
    }
}
