class Solution {
  public:
    int findEquilibrium(vector<int> &arr) {
        vector<int>prefix(arr.size(),0);
        for(int i = 0;i<arr.size();i++){
            if(!i)prefix[i] = arr[i];
            else prefix[i] = arr[i] + prefix[i-1];
        }
        for(int i = 0;i<arr.size();i++){
            int total = prefix.back() - arr[i];
            int leftSum = prefix[i] - arr[i];
            if(total == leftSum * 2)return i;
        }
        return -1;
    }
};
