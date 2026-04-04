class Solution {
  public:
    vector<string> graycode(int n) {
        vector<string> res;
        res.push_back("0");
        res.push_back("1");
        for(int i = 2; i <= n; i++) {
            int size = res.size();
            for(int j = size - 1; j >= 0; j--) {
                res.push_back(res[j]);
            }
            for(int j = 0; j < size; j++) {
                res[j] = "0" + res[j];
            }
            for(int j = size; j < 2 * size; j++) {
                res[j] = "1" + res[j];
            }
        }
        if(n == 1) return res;
        return res;
    }
};
