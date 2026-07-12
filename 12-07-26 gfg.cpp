class Solution {
  public:
    int maxAmount(vector<int>& arr, int k) {
        const long long MOD = 1000000007LL;
        int mx = 0;
        for (int x : arr) mx = max(mx, x);
        auto countAbove = [&](int level) {
            long long cnt = 0;
            for (int x : arr) {
                if (x > level) {
                    cnt += (x - level);
                    if (cnt > k) break;
                }
            }
            return cnt;
        };
        int lo = 0, hi = mx;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (countAbove(mid) <= k)
                hi = mid;
            else
                lo = mid + 1;
        }
        long long level = lo;
        long long sold = 0;
        long long ans = 0;
        for (int x : arr) {
            if (x > level) {
                long long n = x - level;
                sold += n;
                long long sum = (1LL * x * (x + 1) / 2) -
                                (level * (level + 1) / 2);
                ans = (ans + sum) % MOD;
            }
        }
        long long rem = k - sold;
        ans = (ans + (rem % MOD) * (level % MOD)) % MOD;
        return (int)ans;
    }
};
