class Solution {
    public int findKRotation(int arr[]) {
        int n = arr.length;
        int low = 0, high = n - 1;
        if (arr[low] <= arr[high]) {
            return 0;
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid > 0 && arr[mid] < arr[mid - 1]) {
                return mid;
            }
            if (mid < n - 1 && arr[mid] > arr[mid + 1]) {
                return mid + 1;
            }
            if (arr[mid] >= arr[low]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return 0;
    }
}
