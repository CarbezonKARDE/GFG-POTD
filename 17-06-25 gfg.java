import java.util.*;
class Solution {
    public int minimumCoins(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }
        long[] suffixSum = new long[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + arr[i];
        }
        long minRemove = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int minVal = arr[i];
            int maxAllowed = minVal + k;
            int low = i, high = n - 1, validEnd = i;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (arr[mid] <= maxAllowed) {
                    validEnd = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            long removeLeft = prefixSum[i];
            int countRight = n - 1 - validEnd;
            long sumRight = suffixSum[validEnd + 1];
            long idealRight = (long)(maxAllowed) * countRight;
            long removeRight = sumRight - idealRight;

            long totalRemove = removeLeft + removeRight;
            minRemove = Math.min(minRemove, totalRemove);
        }
        return (int) minRemove;
    }
}
