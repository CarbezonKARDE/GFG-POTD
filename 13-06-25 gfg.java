[⚠️ Suspicious Content] class Solution {
    public int kokoEat(int[] arr, int k) {
        int low = 1;
        int high = getMax(arr);
        int result = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canEatAll(arr, k, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }
    private int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int val : arr) {
            if (val > max) max = val;
        }
        return max;
    }
    private boolean canEatAll(int[] arr, int k, int s) {
        int hours = 0;
        for (int pile : arr) {
            hours += (pile + s - 1) / s;  // Efficient way of doing ceil(pile / s)
        }
        return hours <= k;
    }
}
