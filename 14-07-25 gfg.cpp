class Solution {
  public:
    unordered_set<long long> powersOfFive;
    unordered_map<int, int> memo;
    bool isPowerOfFive(string &s, int l, int r) {
        if (s[l] == '0') return false;  // No leading zeros
        long long num = 0;
        for (int i = l; i <= r; ++i) {
            num = (num << 1) + (s[i] - '0');
        }
        return powersOfFive.count(num);
    }
    void precomputePowersOfFive() {
        powersOfFive.clear();
        long long p = 1;
        while (p <= (1LL << 30)) {
            powersOfFive.insert(p);
            p *= 5;
        }
    }
    int dfs(string &s, int idx) {
        if (idx == s.size()) return 0;
        if (memo.count(idx)) return memo[idx];

        int minCuts = INT_MAX;
        for (int j = idx; j < s.size(); ++j) {
            if (isPowerOfFive(s, idx, j)) {
                int cuts = dfs(s, j + 1);
                if (cuts != -1)
                    minCuts = min(minCuts, 1 + cuts);
            }
        }
        return memo[idx] = (minCuts == INT_MAX ? -1 : minCuts);
    }
    int cuts(string s) {
        precomputePowersOfFive();
        memo.clear();
        return dfs(s, 0);
    }
};
