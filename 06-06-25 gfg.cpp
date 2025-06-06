class Solution {
  public:
    vector<int> search(string &pat, string &txt) {
        int m = pat.length();
        int n = txt.length();
        vector<int> lps(m, 0);
        vector<int> result;
        int len = 0;
        for (int i = 1; i < m;) {
            if (pat[i] == pat[len]) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        int i = 0, j = 0;
        while (i < n) {
            if (pat[j] == txt[i]) {
                i++;
                j++;
            }
            if (j == m) {
                result.push_back(i - j + 1);
                j = lps[j - 1];
            } else if (i < n && pat[j] != txt[i]) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return result;
    }
};
