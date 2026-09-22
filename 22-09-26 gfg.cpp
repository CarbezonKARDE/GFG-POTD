class Solution {
  public:
    string findLongestWord(string &s, vector<string> &d) {
        vector<int> pos[26];
        for (int i = 0; i < s.size(); i++) {
            pos[s[i] - 'a'].push_back(i);
        }
        string ans = "";
        for (string &word : d) {
            int prev = -1;
            bool ok = true;
            for (char c : word) {
                auto &v = pos[c - 'a'];
                auto it = upper_bound(v.begin(), v.end(), prev);
                if (it == v.end()) {
                    ok = false;
                    break;
                }
                prev = *it;
            }
            if (ok) {
                if (word.length() > ans.length() ||
                    (word.length() == ans.length() && word < ans)) {
                    ans = word;
                }
            }
        }
        return ans;
    }
};
