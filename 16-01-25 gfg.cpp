class Solution {
  public:
    int maxLen(vector<int> &arr) {
          unordered_map<int,int>mp;
          int n=arr.size();
        for (int i=0;i<n;i++){
            if (arr[i]==0) arr[i]=-1;
        }
        int sum=0;
        int maxi=0;
        for (int i=0;i<n;i++){
            sum+=arr[i];
            if (sum==0) maxi=i+1;
             if (mp.find(sum)!=mp.end()){
                 maxi=max(maxi,i-mp[sum]);
            }
            if (mp.find(sum)==mp.end()){
                mp[sum]=i;
            }
        }
        return maxi;
    }
};
