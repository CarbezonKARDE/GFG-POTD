class Solution {
  public:
    static bool cmp(vector<int>&a,vector<int>&b){
        if(a[0]==b[0]){
            return a[1]<b[1];
        }
        return a[0]<b[0];
    }
    vector<vector<int>> mergeOverlap(vector<vector<int>>& arr) {
        vector<vector<int>>ans;
        sort(arr.begin(),arr.end(),cmp);
        int s = arr[0][0];
        int e = arr[0][1];
        ans.push_back({s,e});
        for(int i=1;i<arr.size();i++){
            if(arr[i][0]>e){
                s=arr[i][0];
                e=arr[i][1];
                ans.push_back({s,e});
            }
            else{
                vector<int>t = ans.back();
                ans.pop_back();
                s=t[0];
                e =max(arr[i][1],e);
                ans.push_back({s,e});
            }
        }
        return ans;
    }
};
