class Solution {
  public:
    long subarrayXor(vector<int> &arr, int k) {
        unordered_map<int, int> mp;
        int xr = 0;
        long count = 0;
        mp[0] = 1;
        for (int num : arr) {
            xr ^= num;
            int x = xr ^ k;
            if (mp.find(x) != mp.end()) {
                count += mp[x];
            }
            mp[xr]++;
        }
        return count;
    }
};
