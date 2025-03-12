class Solution {
    public static int rec(int i,int n,int W,int[] val,int[] wt,int curr,int[][] dp){
        if(i>=n)return 0;
        if(dp[i][curr]!=-1)return dp[i][curr];
        int take=Integer.MIN_VALUE,notTake=Integer.MIN_VALUE;
        if(curr+wt[i]<=W)
            take=val[i]+rec(i+1,n,W,val,wt,curr+wt[i],dp);
        notTake=rec(i+1,n,W,val,wt,curr,dp);
        return dp[i][curr]=Math.max(take,notTake);
    }
    static int knapsack(int W, int val[], int wt[]) {
        int n=wt.length;
        int[][] dp=new int[n+1][W+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=W;j++){
                dp[i][j]=-1;
            }
        }
        return rec(0,n,W,val,wt,0,dp);
    }
}
