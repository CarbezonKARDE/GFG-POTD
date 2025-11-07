import java.util.*;
class Solution {
    public int maxProfit(int[][] jobs) {
        int n = jobs.length;
        Arrays.sort(jobs, (a, b) -> {
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });
        int[] end = new int[n];
        for (int i = 0; i < n; i++) end[i] = jobs[i][1];
        long[] dp = new long[n];
        dp[0] = jobs[0][2];
        for (int i = 1; i < n; i++) {
            long take = jobs[i][2];
            int j = upperBound(end, jobs[i][0]) - 1;
            if (j >= 0) take += dp[j];
            long skip = dp[i - 1];
            dp[i] = Math.max(take, skip);
        }
        return (int) dp[n - 1];
    }
    private int upperBound(int[] arr, int key) {
        int lo = 0, hi = arr.length; // [lo, hi)
        while (lo < hi) {
            int mid = lo + ((hi - lo) >>> 1);
            if (arr[mid] <= key) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}
