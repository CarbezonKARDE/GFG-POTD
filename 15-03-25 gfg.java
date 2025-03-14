class Solution {
    public int minCoins(int coins[], int sum) {
        coins = Arrays.stream(coins).filter(coin -> coin > 0).toArray();
        int n = coins.length;
        int[][] t = new int[n + 1][sum + 1];
        for (int j = 1; j <= sum; j++) {
            t[0][j] = Integer.MAX_VALUE - 1;
        }
        for (int i = 0; i <= n; i++) {
            t[i][0] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (coins[i - 1] <= j) {
                    t[i][j] = Math.min(t[i - 1][j], 1 + t[i][j - coins[i - 1]]);
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[n][sum] == Integer.MAX_VALUE - 1 ? -1 : t[n][sum];
    }
}
