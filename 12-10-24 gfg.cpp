class Solution {
  public:
    int pairWithMaxSum(vector<int>& arr) {
        int maxi=-1;
        int n=arr.size();
        for(int i=1;i<n;i++){
            maxi=max(maxi,arr[i]+arr[i-1]);
        }
        return maxi;
    }
};
