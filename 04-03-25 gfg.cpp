class Solution {
  public:
    int helper(int idx, int prev, int n, vector<int>& arr,
               vector<vector<int>>& dp)
    {
        if (idx >= n)
            return 0;
        if (prev != -1 && dp[idx][prev] != -1)
            return dp[idx][prev];
        int nopick = helper(idx + 1, prev,n, arr,dp);
        int pick = 0;
        if ((prev == -1) || (arr[prev] < arr[idx]))
            pick = 1 + helper(idx + 1, idx,n, arr,dp);
        if (prev != -1)
            dp[idx][prev] = max(pick, nopick);
        return max(pick, nopick);
    }
    int lis(vector<int>& arr) {
        int n = arr.size();
        vector<vector<int>> dp(n,vector<int>(n,-1));
        return helper(0,-1,n,arr,dp);
    }
};
