class Solution {
  public:
    static const long long MOD = 1000000007;
    long long power(long long a, long long b) {
        long long res = 1;
        while (b) {
            if (b & 1)
                res = res * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }
    int prefixStrings(int n) {
        vector<long long> fact(2 * n + 1, 1);
        for (int i = 1; i <= 2 * n; i++)
            fact[i] = fact[i - 1] * i % MOD;
        long long numerator = fact[2 * n];
        long long denominator = fact[n] * fact[n] % MOD;
        long long comb = numerator * power(denominator, MOD - 2) % MOD;
        long long ans = comb * power(n + 1, MOD - 2) % MOD;
        return ans;
    }
};
