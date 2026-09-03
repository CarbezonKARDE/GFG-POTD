class Solution {
    public int maxDiffSum(int[] arr) {
        int n = arr.length;
        if (n <= 1) return 0;
        long keep = 0;
        long replace = 0;
        for (int i = 1; i < n; i++) {
            long newKeep = Math.max(
                keep + Math.abs((long) arr[i] - arr[i - 1]),
                replace + Math.abs((long) arr[i] - 1)
            );
            long newReplace = Math.max(
                keep + Math.abs(1L - arr[i - 1]),
                replace
            );
            keep = newKeep;
            replace = newReplace;
        }
        return (int) Math.max(keep, replace);
    }
}
