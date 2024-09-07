class Solution {
  public:
    int minJumps(vector<int>& arr) {
        for(int i=0;i<arr.size();i++)
            arr[i]+=i;
        for(int i=1;i<arr.size();i++){
            arr[i]=max(arr[i],arr[i-1]);
        }
        int i=0;
        int ans=0;
        int n=arr.size();
        while(!(i>=n-1)){
            if(i==arr[i])
                return -1;
            i=arr[i];
            ans++;
        }
        return ans;
    }
};
