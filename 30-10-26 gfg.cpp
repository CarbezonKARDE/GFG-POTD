class Solution {
  public:
    int cntSubsets(vector<int> &arr, int l, int r) {
        const long long MOD = 1000000007;
        int n = arr.size();
        vector<int> freq(n + 1, 0);
        for (int x : arr) {
            if (x <= n)
                freq[x]++;
        }
        vector<long long> pow2(n + 1, 1);
        for (int i = 1; i <= n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }
        vector<int> suffix(n + 2, 0);
        for (int i = n; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + freq[i];
        }
        long long ans = 0;
        long long requiredWays = 1;
        for (int mex = 0; mex <= min(r, n); mex++) {
            if (mex >= l) {
                long long ways = requiredWays;
                ways = (ways * pow2[suffix[mex + 1]]) % MOD;
                ans = (ans + ways) % MOD;
            }
            requiredWays =
                (requiredWays * (pow2[freq[mex]] - 1 + MOD)) % MOD;
            if (freq[mex] == 0)
                break;
        }
        return ans;
    }
};
