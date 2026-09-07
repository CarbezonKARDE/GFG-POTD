class Solution {
    public int minCount(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int pos = 1; pos <= n; pos++) {
            int x = arr[pos - 1];
            for (int inc = 0; inc < pos; inc++) {
                for (int dec = 0; dec < pos; dec++) {
                    int current = dp[inc][dec];
                    if (inc == 0 || x > arr[inc - 1]) {
                        dp[pos][dec] = Math.max(dp[pos][dec], current + 1);
                    }
                    if (dec == 0 || x < arr[dec - 1]) {
                        dp[inc][pos] = Math.max(dp[inc][pos], current + 1);
                    }
                }
            }
        }
        int maxSelected = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                maxSelected = Math.max(maxSelected, dp[i][j]);
            }
        }
        return n - maxSelected;
    }
}
