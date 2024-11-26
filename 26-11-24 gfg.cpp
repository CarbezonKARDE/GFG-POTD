class Solution {
  public:
    int circularSubarraySum(vector<int> &arr) {
        int sum=0;
        int currmin=0,currmax=0,minSum=1e9,maxSum=0;
        for(int &i:arr){
            sum+=i;
            currmin+=i;
            currmax+=i;
            if(currmin>0)currmin=0;
            if(currmax<0)currmax=0;
            minSum=min(minSum,currmin);
            maxSum=max(maxSum,currmax);
        }
        return max(sum-minSum,maxSum);
    }
};
