class Solution {
  public:
    unordered_map<int, int> dp;
    int solve(int n) {
        if(n == 0) return 0;
        if(dp.count(n)) return dp[n];
        int broken = solve(n/2) + solve(n/3) + solve(n/4);
        return dp[n] = max(n, broken);
    }
    int maxSum(int n) {
        return solve(n);
    }
};
