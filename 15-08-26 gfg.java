class Solution {
    public int countWithout(int n, int d) {
        if (n == 0) return 0;
        String s = String.valueOf(n);
        int len = s.length();
        int[][][] dp = new int[len + 1][2][2];
        dp[0][1][0] = 1;
        for (int pos = 0; pos < len; pos++) {
            for (int tight = 0; tight <= 1; tight++) {
                for (int started = 0; started <= 1; started++) {
                    int cur = dp[pos][tight][started];
                    if (cur == 0) continue;
                    int limit = tight == 1 ? s.charAt(pos) - '0' : 9;
                    for (int digit = 0; digit <= limit; digit++) {
                        int newTight = (tight == 1 && digit == limit) ? 1 : 0;
                        int newStarted = (started == 1 || digit != 0) ? 1 : 0;
                        if (newStarted == 1 && digit == d) {
                            continue;
                        }
                        dp[pos + 1][newTight][newStarted] += cur;
                    }
                }
            }
        }
        return dp[len][0][1] + dp[len][1][1];
    }
}
