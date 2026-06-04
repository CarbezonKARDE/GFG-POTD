class Solution {
  public:
    int maxSubstring(string &s) {
        int curr = 0, maxi = -1;
        for(char c : s) {
            int val = (c == '0') ? 1 : -1;
            curr = max(val, curr + val);
            maxi = max(maxi, curr);
        }
        return maxi;
    }
};
