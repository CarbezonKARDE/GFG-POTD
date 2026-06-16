class Solution {
  public:
    vector<int> constructList(vector<vector<int>> &queries) {
        vector<int> arr;
        int xr = 0;
        arr.push_back(0);
        for (auto &q : queries) {
            int type = q[0];
            int x = q[1];
            if (type == 0) {
                arr.push_back(x ^ xr);
            } else {
                xr ^= x;
            }
        }
        for (int &val : arr) {
            val ^= xr;
        }
        sort(arr.begin(), arr.end());
        return arr;
    }
};
