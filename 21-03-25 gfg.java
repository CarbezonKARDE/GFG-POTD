class Solution {
    public int findMaxSum(int arr[]) {
        int n =arr.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return f(0, arr, n, dp);
    }
    int f(int i  ,int arr[], int n, int dp[] ){
        if(i>=n)return 0;
        if(dp[i]!=-1)return dp[i];
        return dp[i]= Math.max(arr[i] + f(i+2,arr, n, dp ),f(i+1, arr,n, dp));
    }
}
