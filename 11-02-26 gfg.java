import java.util.*;
class Solution {
    public int minCost(int[] heights, int[] cost) {
        int n = heights.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = heights[i];
            arr[i][1] = cost[i];
        }
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        long totalWeight = 0;
        for (int i = 0; i < n; i++) {
            totalWeight += arr[i][1];
        }
        long curr = 0;
        int targetHeight = 0;
        for (int i = 0; i < n; i++) {
            curr += arr[i][1];
            if (curr >= (totalWeight + 1) / 2) {
                targetHeight = arr[i][0];
                break;
            }
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += (long) Math.abs(arr[i][0] - targetHeight) * arr[i][1];
        }
        return (int) ans;
    }
}
