class Solution {
    private int digitSum(long x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
    public int getCount(int n, int d) {
        long low = 1;
        long high = n;
        long ans = n + 1;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (mid - digitSum(mid) >= d) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (ans == n + 1) return 0;
        return (int)(n - ans + 1);
    }
}
