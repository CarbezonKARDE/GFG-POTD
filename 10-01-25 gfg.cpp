class Solution {
  public:
    vector<int> countDistinct(vector<int> &arr, int k) {
        map<int,int> mp;
        vector<int> ans;
        int len = arr.size();
        int start = 0;
        for(int i = 0; i < k; i++)
        {
            
            mp[arr[i]]++;
        }
        ans.push_back(mp.size());
        while(k < len)
        {
            mp[arr[start]]--;
            if(mp[arr[start]] < 1)
                mp.erase(arr[start]);
            mp[arr[k]]++;
            start++;
            ans.push_back(mp.size());
            k++;
        }
        return ans;
    }
};
