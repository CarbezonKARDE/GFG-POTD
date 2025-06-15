class Solution {
    int smallestDivisor(int[] arr, int k) {
        int left = 1, right = getMax(arr);
        int ans = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (getSum(arr, mid) <= k) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
    int getMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) max = num;
        }
        return max;
    }
    int getSum(int[] arr, int divisor) {
        int sum = 0;
        for (int num : arr) {
            sum += (num + divisor - 1) / divisor; // same as ceil(num / divisor)
        }
        return sum;
    }
}
