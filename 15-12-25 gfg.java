class Solution {
    public int cntWays(int[] arr) {
        int n = arr.length;
        int totalEven = 0, totalOdd = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) totalEven += arr[i];
            else totalOdd += arr[i];
        }
        int leftEven = 0, leftOdd = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int rightEven = totalEven - leftEven;
            int rightOdd  = totalOdd  - leftOdd;
            if (i % 2 == 0) rightEven -= arr[i];
            else rightOdd -= arr[i];
            int newEven = leftEven + rightOdd;
            int newOdd  = leftOdd + rightEven;
            if (newEven == newOdd) count++;
            if (i % 2 == 0) leftEven += arr[i];
            else leftOdd += arr[i];
        }
        return count;
    }
}
