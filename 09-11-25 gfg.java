class Solution {
    public int chocolatePickup(int[][] mat) {
        int n = mat.length;
        Integer[][][] dp = new Integer[n][n][2 * n];
        int res = solve(0, 0, 0, mat, dp, n);
        return Math.max(0, res);
    }
    private int solve(int i1, int i2, int k, int[][] mat, Integer[][][] dp, int n) {
        int j1 = k - i1; 
        int j2 = k - i2;
        if (i1 >= n || j1 >= n || i2 >= n || j2 >= n || 
            mat[i1][j1] == -1 || mat[i2][j2] == -1) {
            return Integer.MIN_VALUE;
        }
        if (i1 == n - 1 && j1 == n - 1) {
            return mat[i1][j1];
        }
        if (dp[i1][i2][k] != null) return dp[i1][i2][k];
        int curr = (i1 == i2 && j1 == j2) ? mat[i1][j1] : mat[i1][j1] + mat[i2][j2];
        int best = Math.max(
            Math.max(solve(i1 + 1, i2 + 1, k + 1, mat, dp, n), 
                     solve(i1 + 1, i2, k + 1, mat, dp, n)),
            Math.max(solve(i1, i2 + 1, k + 1, mat, dp, n),
                     solve(i1, i2, k + 1, mat, dp, n))
        );
        if (best == Integer.MIN_VALUE) return dp[i1][i2][k] = Integer.MIN_VALUE;
        return dp[i1][i2][k] = curr + best;
    }
}
