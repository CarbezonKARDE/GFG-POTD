class Solution {
    int missingNumber(int n, int arr[]) {
        int sum =0;
        for(int i=0;i<n-1;i++){
            sum =sum+arr[i];
        }
        int result = n*(n+1)/2;
        return result -sum;
    }
}
