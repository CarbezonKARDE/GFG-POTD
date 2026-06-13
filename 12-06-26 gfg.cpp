class Solution {
  public:
    bool kSubstr(string &s, int k) {
        int n = s.size();
        if (n % k != 0) return false;
        unordered_map<string, int> freq;
        for (int i = 0; i < n; i += k) {
            freq[s.substr(i, k)]++;
        }
        int blocks = n / k;
        if (freq.size() == 1) return true;
        if (freq.size() == 2) {
            for (auto &p : freq) {
                if (p.second == 1) return true;
            }
            if (blocks == 2) return true;
        }
        return false;
    }
};
