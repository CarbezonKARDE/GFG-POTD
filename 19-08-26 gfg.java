class Solution {
    public int countTriplets(int[] arr, int l, int r) {
        Arrays.sort(arr);
        long ans = countLessEqual(arr, r) - countLessEqual(arr, l - 1);
        return (int) ans;
    }
    private long countLessEqual(int[] arr, int x) {
        int n = arr.length;
        long count = 0;
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum <= x) {
                    count += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }
        return count;
    }
}
