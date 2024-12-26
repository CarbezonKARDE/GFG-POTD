class Solution {
  public:
    bool twoSum(vector<int>& arr, int target) {
        // code here
        int size=arr.size();
        if(size<2){
            return false;
        }
        sort(arr.begin(),arr.end());
        int left=0;
        int right=size-1;
        while(left<right){
            if(arr[left]+arr[right]==target){
                return true;
            }
            else if(arr[left]+arr[right]<target){
                left++;
            }
            else{
                right--;
            }
        }
        return false;
    }
};
