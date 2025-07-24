class Solution {
    public int maxCircularSum(int arr[]) {
        int n = arr.length;
        int totalSum = 0;
        int maxKadane = kadane(arr);
        int minSubarraySum = Integer.MAX_VALUE;
        int currMin = 0;
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
            currMin += arr[i];
            if (currMin < minSubarraySum) minSubarraySum = currMin;
            if (currMin > 0) currMin = 0;
        }
        if (totalSum == minSubarraySum) {
            return maxKadane;
        }
        int maxCircular = totalSum - minSubarraySum;
        return Math.max(maxKadane, maxCircular);
    }
    private int kadane(int[] arr) {
        int maxSoFar = arr[0];
        int currMax = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currMax = Math.max(arr[i], currMax + arr[i]);
            maxSoFar = Math.max(maxSoFar, currMax);
        }
        return maxSoFar;
    }
}
