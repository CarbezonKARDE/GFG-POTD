class Solution {
public:
    int LCIS(vector<int> &a, vector<int> &b) {
        int n = a.size(), m = b.size();
        vector<int> dp(m, 0);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int current_best = 0;
            for (int j = 0; j < m; j++) {
                if (b[j] < a[i]) {
                    current_best = max(current_best, dp[j]);
                } 
                else if (b[j] == a[i]) {
                    dp[j] = current_best + 1;
                    ans = max(ans, dp[j]);
                }
            }
        }
        return ans;
    }
};
