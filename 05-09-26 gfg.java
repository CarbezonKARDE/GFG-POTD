class Solution {
public int longestSubseq(int[] arr) {
int MAX = 1_000_001;
int[] dp = new int[MAX + 2];
    int ans = 1;
    for (int x : arr) {
        int curr = Math.max(dp[x - 1], dp[x + 1]) + 1;

        if (curr > dp[x]) {
            dp[x] = curr;
        }
        ans = Math.max(ans, dp[x]);
    }
    return ans;
}
}
