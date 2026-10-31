class Solution {
    public int maxPackages(int[] arr, int totalTime) {
        int n = arr.length;
        int sum = 0;
        int maxSum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (i >= totalTime) {
                sum -= arr[i - totalTime];
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
