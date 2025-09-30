class Solution {
  public:
    vector<string> binstr(int n) {
        vector<string> res;
        int total = 1 << n;
        for (int i = 0; i < total; i++) {
            string s = "";
            for (int j = n - 1; j >= 0; j--) {
                s += ((i >> j) & 1) ? '1' : '0';
            }
            res.push_back(s);
        }
        return res;
    }
};
