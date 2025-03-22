class Solution {
    public int countWays(String s) {
         int mod = 1000000007;
        int n = s.length();
        long[] dp = new long[n + 2];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
            }
            if (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')) {
                dp[i] = (dp[i] + dp[i - 2]) % mod;
            }
        }
        return (int) dp[n];
    }
}
