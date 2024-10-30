class Solution {
  public:
    int countPairsWithDiffK(vector<int>& arr, int k) {
         int n = arr.size();
        int count = 0;
        unordered_map<int, int> mp;
        for(int i=0; i<n; i++){
            int add = arr[i] + k;
            int sub = arr[i] - k;
            count += mp[add]; count += mp[sub];
            mp[arr[i]]++;
        }
        return count;
    }
};
