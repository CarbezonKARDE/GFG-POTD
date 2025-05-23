class Solution {
  public:
    int findMaximum(vector<int> &arr) {
        int n=arr.size();
        if(arr.size()==1 || arr[0]>arr[1]) return arr[0];
        if(arr[n-1]>arr[n-2]) return arr[n-1];
        int low=1,high=arr.size()-2;
        while(low<high){
            int mid=low+(high-low)/2;
            if(arr[mid]>arr[mid+1] && arr[mid]>arr[mid-1]) return arr[mid];
            else if(arr[mid]<arr[mid+1]){
                low=mid+1;
            }
            else high=mid-1;
        }
        return arr[low];
    }
};
