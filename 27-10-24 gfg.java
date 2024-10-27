class Solution {
    public boolean findTriplet(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int target = arr[i];
            int left = 0, right = n - 1;
            while (left < right) {
                if (left == i) {
                    left++;
                    continue;
                }
                if (right == i) {
                    right--;
                    continue;
                }
                int currentSum = arr[left] + arr[right];
                if (currentSum == target) {
                    return true;
                } else if (currentSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return false;
    }
}
