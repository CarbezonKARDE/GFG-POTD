class Solution {
  public:
    int findDuplicate(vector<int>& arr) {
        sort(arr.begin(),arr.end());
        int n=arr.size();
        for(int i=1;i<n;i++)
        {
            if(arr[i-1]==arr[i])
            return arr[i];
        }
    }
};
