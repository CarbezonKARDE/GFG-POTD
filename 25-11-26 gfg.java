class Solution {
    static final long MOD = 1000000007L;
    static long floorSum(long n, long m, long a, long b) {
        long ans = 0;
        while (true) {
            if (a >= m) {
                ans += (n - 1) * n * (a / m) / 2;
                a %= m;
            }
            if (b >= m) {
                ans += n * (b / m);
                b %= m;
            }
            long y = a * n + b;
            if (y < m) break;
            n = y / m;
            b = y % m;
            long temp = m;
            m = a;
            a = temp;
        }
        return ans;
    }
    public int minTime(int a, int b, int d, int l, int r) {
        long L = (long) d - r;
        long R = (long) d - l;
        long count = R - L + 1;
        long sumX = (L + R) * count / 2;
        long ans = sumX + count;
        long start = Math.max(L, (long) a + 1);
        if (start <= R) {
            long n = R - start + 1;
            long c = a - b;
            long sumCeil = floorSum(
                n,
                c,
                1,
                start - a + c - 1
            );
            ans += 2L * b * sumCeil;
        }
        return (int) (ans % MOD);
    }
}
