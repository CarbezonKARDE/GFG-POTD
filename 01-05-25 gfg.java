class Solution {
    ArrayList<Integer> nthRowOfPascalTriangle(int n) {
        int dp[][] = new int[n][n];
        dp[0][0] = 1;
        for(int i=1;i<n;i++){
            for(int j=0;j<=i;j++){
                if(j==0){
                    dp[i][j]=1;
                    continue;
                }
                dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            ans.add(dp[n-1][i]);
        }
        return ans;
    }
}
