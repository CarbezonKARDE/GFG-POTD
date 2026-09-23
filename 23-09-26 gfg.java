class Solution {
    public int formPyramid(int[] arr) {
        int n = arr.length;
        long total = 0;
        for (int x : arr) {
            total += x;
        }
        long[] left = new long[n];
        left[0] = Math.min(arr[0], 1);
        for (int i = 1; i < n; i++) {
            left[i] = Math.min((long) arr[i], left[i - 1] + 1);
        }
        long[] right = new long[n];
        right[n - 1] = Math.min(arr[n - 1], 1);
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.min((long) arr[i], right[i + 1] + 1);
        }
        long maxKept = 0;
        for (int i = 0; i < n; i++) {
            long height = Math.min(left[i], right[i]);
            maxKept = Math.max(maxKept, height * height);
        }
        return (int) (total - maxKept);
    }
}
