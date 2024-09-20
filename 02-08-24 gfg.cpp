class Solution {
  private:
    int solve(int i, int j, int n, int m, string& str1, string& str2, vector<vector<int>>& dp){
        if(j==m){
            return n-i;
        }if(i==n){
            return m-j;
        }if(dp[i][j] != -1){
            return dp[i][j];
        }if(str1[i]==str2[j]){
            return dp[i][j] = solve(i+1,j+1,n,m,str1,str2,dp);
        }
        int o1 = 1 + solve(i,j+1,n,m,str1,str2,dp);
        int o2 = 1 + solve(i+1,j,n,m,str1,str2,dp);
        int o3 = 1 + solve(i+1,j+1,n,m,str1,str2,dp);
        return dp[i][j] = min(o1,min(o2,o3));
    }
  public:
    int editDistance(string str1, string str2) {
        int n = str1.size(),m=str2.size();
        vector<vector<int>> dp(n,vector<int>(m,-1));
        return solve(0,0,n,m,str1,str2,dp);
    }
};
