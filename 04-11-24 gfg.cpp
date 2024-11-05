class Solution {
  public:
    vector<vector<int>> findTriplets(vector<int> &arr) {
        int n=arr.size();
        vector<vector<int>> result;
        for(int i=0;i<n-2;i++)
        {
            unordered_map<int,vector<int>> mp;
            for(int k=i+1;k<n;k++)
            {
                if( mp.find(-(arr[i]+arr[k]))!=mp.end())
                {
                    for(auto x  : mp[-(arr[i]+arr[k])])
                    {
                        result.push_back({i,x,k});
                    }
                }
                mp[arr[k]].push_back(k);
            }
        }
        return result;
    }
};
