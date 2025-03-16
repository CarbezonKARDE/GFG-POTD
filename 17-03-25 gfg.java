class Solution {
    static Boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length ;
        boolean dp[] [] = new boolean [n][ sum+1];
        for(int i = 0 ; i< n;i++) dp[i][0] = true;
        if(arr[0] <= sum) dp[0][arr[0]] = true;
        for(int i =1 ; i< n;i++){
            for(int j =1 ; j<= sum ; j++){
                boolean notTake = dp[i-1][j];
                boolean take = false;
                if( j >= arr[i]){
                    take = dp[i-1][j-arr[i]];
                }
                dp[i][j] = take || notTake;
            }
        }
        return dp[n-1][sum];
    }
}
