class Solution {
    static Integer[][]dp;
    public static int dfs(int w,int[]wt,int[]val,int index,int sum)
    {
        if(index>=val.length)
        return 0;
        int pick=0;
        if(dp[index][sum]!=null)return dp[index][sum];
        
        if(wt[index]+sum<=w)
        {
            pick=val[index]+dfs(w,wt,val,index+1,sum+wt[index]);
        }
        int notpick=dfs(w,wt,val,index+1,sum);
        return dp[index][sum]=Math.max(pick,notpick);
    }
    static int knapSack(int W, int wt[], int val[]) {
        dp=new Integer[val.length][W+1];
        return dfs(W,wt,val,0,0);
    }
}
