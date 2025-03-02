class Solution {
  public:
    vector<int> maxOfSubarrays(vector<int>& arr, int k) {
        int n=arr.size();
        vector<int>ans;
        priority_queue<pair<int,int>>maxi;
        for(int i=0;i<k;i++){
            maxi.push({arr[i],i});
        }
        ans.push_back(maxi.top().first);
        for(int i=k;i<n;i++){
            maxi.push({arr[i],i});
            while(maxi.top().second<=i-k){
                maxi.pop();
            }
            ans.push_back(maxi.top().first);
        }
        return ans;
    }
};
