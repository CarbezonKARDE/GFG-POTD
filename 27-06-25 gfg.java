class Solution {
    public int getCount(int n) {
        if (n <= 0) return 0;
        int[][] moves = {
            {0, 8},    
            {1, 2, 4}, 
            {2, 1, 3, 5},
            {3, 2, 6}, 
            {4, 1, 5, 7},
            {5, 2, 4, 6, 8},
            {6, 3, 5, 9},
            {7, 4, 8}, 
            {8, 5, 7, 9, 0}, 
            {9, 6, 8}  
        };
        int[][] dp = new int[n + 1][10];
        for (int digit = 0; digit <= 9; digit++) {
            dp[1][digit] = 1;
        }
        for (int len = 2; len <= n; len++) {
            for (int digit = 0; digit <= 9; digit++) {
                for (int next : moves[digit]) {
                    dp[len][digit] += dp[len - 1][next];
                }
            }
        }
        int total = 0;
        for (int digit = 0; digit <= 9; digit++) {
            total += dp[n][digit];
        }
        return total;
    }
}
