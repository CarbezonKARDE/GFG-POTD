class Solution {
    public static int countSetBits(int n) {
        return helper(n);
    }
    private static int helper(int n) {
        if (n == 0) return 0;

        int x = highestPowerOf2(n);
        int bitsUpTo2x = x * (1 << (x - 1));
        int msbBits = n - (1 << x) + 1;
        int rest = n - (1 << x);
        return bitsUpTo2x + msbBits + helper(rest);
    }
    private static int highestPowerOf2(int n) {
        int x = 0;
        while ((1 << (x + 1)) <= n) x++;
        return x;
    }
}
