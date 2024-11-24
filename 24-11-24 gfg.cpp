class Solution {
  public:
    int maxSubarraySum(vector<int> &arr) {
         int sum=0,ans=INT_MIN,n=arr.size();
        for(int i=0;i<n;i++){
            sum+=arr[i];
            ans=max(ans,sum);
            if(sum<0)sum=0;
        }
        return ans;
    }
};
