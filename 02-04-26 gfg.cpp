class Solution {
  public:
    int countWays(int n, int k) {
        if (n == 1) return k;
        long long same = 0;
        long long diff = k;
        for (int i = 2; i <= n; i++) {
            long long newSame = diff;
            long long newDiff = (same + diff) * (k - 1);
            same = newSame;
            diff = newDiff;
        }
        return same + diff;
    }
};
