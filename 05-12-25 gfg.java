class Solution {
    int minCost(int[][] costs) {
        int n = costs.length;
        if (n == 0) return 0;
        int k = costs[0].length;
        if (k == 0) return -1;
        if (k == 1 && n > 1) return -1;
        int[] prev = new int[k];
        for (int j = 0; j < k; j++) {
            prev[j] = costs[0][j];
        }
        for (int i = 1; i < n; i++) {
            int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
            int color1 = -1;
            for (int j = 0; j < k; j++) {
                if (prev[j] < min1) {
                    min2 = min1;
                    min1 = prev[j];
                    color1 = j;
                } else if (prev[j] < min2) {
                    min2 = prev[j];
                }
            }
            int[] curr = new int[k];
            for (int j = 0; j < k; j++) {
                if (j == color1) {
                    curr[j] = costs[i][j] + min2;
                } else {
                    curr[j] = costs[i][j] + min1;
                }
            }
            prev = curr;
        }
        int ans = Integer.MAX_VALUE;
        for (int val : prev) ans = Math.min(ans, val);
        return ans;
    }
}
