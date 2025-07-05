class Solution {
    public int maxSum(int arr[]) {
        int max = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int sum = arr[i] + arr[i + 1];
            max = Math.max(max, sum);
        }
        return max;
    }
}
