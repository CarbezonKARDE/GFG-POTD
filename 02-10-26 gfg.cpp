class Solution {
public:
    string lexiString(string &s) {
        int n = s.size();
        string t = s + s;
        int i = 0, j = 1, k = 0;
        while (i < n && j < n && k < n) {
            if (t[i + k] == t[j + k]) {
                k++;
                continue;
            }
            if (t[i + k] > t[j + k]) {
                i = i + k + 1;
                if (i <= j)
                    i = j + 1;
            } else {
                j = j + k + 1;
                if (j <= i)
                    j = i + 1;
            }
            k = 0;
        }
        int start = min(i, j);
        return s.substr(start) + s.substr(0, start);
    }
};
