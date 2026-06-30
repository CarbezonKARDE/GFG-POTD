class Solution {
    public int maxSumSubarray(int[] arr) {
        int noSkip = arr[0];
        int oneSkip = -1000000000;
        int ans = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int newOneSkip = Math.max(oneSkip + arr[i], noSkip); // skip current or skipped earlier
            int newNoSkip = Math.max(arr[i], noSkip + arr[i]);
            noSkip = newNoSkip;
            oneSkip = newOneSkip;
            ans = Math.max(ans, Math.max(noSkip, oneSkip));
        }
        return ans;
    }
}
