class Solution {
  public:
  bool solve(int idx,int target,vector<int>arr,vector<vector<int>>&dp){
      if(target==0) return true;
      if(idx<0) return false;
      if(dp[idx][target]!=-1) return dp[idx][target];
      bool pick=false;
      if(target>=arr[idx]) pick=solve(idx-1,target-arr[idx],arr,dp);
      return dp[idx][target]=(pick||solve(idx-1,target,arr,dp));
  }
    bool equalPartition(vector<int>& arr) {
        int sum=accumulate(arr.begin(),arr.end(),0);
        int n=arr.size();
        if(sum%2!=0) return false;
        vector<vector<int>>dp(n+1,vector<int>((sum/2)+1,-1));
        return solve(n-1,sum/2,arr,dp);
    }
};
