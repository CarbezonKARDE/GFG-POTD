class Solution {
    public int splitArray(int[] arr, int k) {
        int low = 0, high = 0;
        for (int num : arr) {
            low = Math.max(low, num);
            high += num;
        }

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canSplit(arr, k, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean canSplit(int[] arr, int k, int maxSumAllowed) {
        int count = 1, currentSum = 0;
        for (int num : arr) {
            if (currentSum + num > maxSumAllowed) {
                count++;
                currentSum = num;
            } else {
                currentSum += num;
            }
        }
        return count <= k;
    }
}
