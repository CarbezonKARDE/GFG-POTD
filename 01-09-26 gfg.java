class Solution {
    static final long MOD = 1_000_000_007L;
    public int palindromicStrings(int n, int k) {
        long ans = 0;
        long perm = 1; 
        for (int m = 0; m <= n / 2; m++) {
            if (2 * m + 1 <= n && m < k) {
                long odd = (perm * (k - m)) % MOD;
                ans = (ans + odd) % MOD;
            }
            if (m > 0 && 2 * m <= n) {
                ans = (ans + perm) % MOD;
            }
            if (m < k) {
                perm = (perm * (k - m)) % MOD;
            }
        }
        return (int) ans;
    }
}
