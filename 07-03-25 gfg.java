class Solution {
    static int[][] dp;
    public boolean isPallin(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString().equals(s);
    }
    public int check(String s, int i, int j) {
        if (i > j) return 0;
        if (i == j) return 1;
        if (dp[i][j] != -1) return dp[i][j];
        if (s.charAt(i) == s.charAt(j)) {
            dp[i][j] = 2 + check(s, i + 1, j - 1);
        } else {
            dp[i][j] = Math.max(check(s, i + 1, j), check(s, i, j - 1));
        }
        return dp[i][j];
    }
    public int longestPalinSubseq(String s) {
        int n = s.length();
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return check(s, 0, n - 1);
    }
}
