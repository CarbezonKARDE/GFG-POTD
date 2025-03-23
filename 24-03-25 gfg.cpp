class Solution {
  public:
  int mcm(int i,int j, vector<int>&arr,vector<vector<int>>&dp){
    if(i==j) return 0;
    if(dp[i][j] != -1) return dp[i][j];
    int mini = 1e9;
    for(int k=i;k<j;k++){
        int steps = arr[i-1] * arr[k] * arr[j] + mcm(i,k,arr,dp) + mcm(k+1,j,arr,dp);
        if(steps < mini){
            mini = steps;
        }
    }
    return dp[i][j] = mini;
}
    int matrixMultiplication(vector<int> &arr) {
        int N = arr.size();
        vector<vector<int>>dp(N,vector<int>(N,-1));
        return mcm(1,N-1,arr,dp);
    }
};
