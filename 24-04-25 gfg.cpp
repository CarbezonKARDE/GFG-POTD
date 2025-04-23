class Solution {
  public:
    int getSingle(vector<int> &arr) {
        unordered_map<int,int> mp;
        for(auto it:arr)
        {
            mp[it]+=1;
        }
        int ans=0;
        for(auto it:mp)
        {
            if(it.second==1)
            ans=it.first;
        }
        return ans;
    }
};
