class Solution {
  public:
    int minJumps(vector<int>& arr) {
        int n = (int)arr.size();
        vector<int> dp(n, INT_MAX);
        dp[0] = 0;
        for(int i = 0; i<n; ++i) {
            if(dp[i]==INT_MAX) continue;
            for(int j = i+1; j<=(i+arr[i]) && j<n; ++j) {
                dp[j] = min(dp[j], dp[i]+1);
            }
        }
        int res = dp[n-1];
        return res == INT_MAX ? - 1 : res;
    }
};
