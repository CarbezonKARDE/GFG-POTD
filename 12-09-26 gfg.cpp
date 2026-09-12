class Solution {
  public:
    int maxProduct(vector<int> &arr, int k) {
        int n = arr.size();
        vector<unordered_set<long long>> dp(k + 1);
        dp[0].insert(1);
        for (int x : arr) {
            for (int j = min(k, n); j >= 1; j--) {
                for (long long p : dp[j - 1]) {
                    dp[j].insert(p * x);
                }
            }
        }
        return (int)*max_element(dp[k].begin(), dp[k].end());
    }
};
