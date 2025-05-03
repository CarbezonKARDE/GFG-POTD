class Solution {
public:
    int findSubString(string& str) {
        int n = str.size();
        vector<bool> visited(26, false);
        int          distinct = 0;
        for (int i = 0; i < n; i++) {
            if (visited[str[i] - 'a'] == false) {
                visited[str[i] - 'a'] = true;
                distinct++;
            }
        }
        vector<int> cur(26, 0);
        int         cnt    = 0;
        int         result = n;
        int         i = 0, j = 0;
        while (j < n) {
            cur[str[j] - 'a']++;
            if (cur[str[j] - 'a'] == 1) {
                cnt++;
            }
            while (cnt == distinct) {
                result = min(result, j - i + 1);
                cur[str[i] - 'a']--;
                if (cur[str[i] - 'a'] == 0) {
                    cnt--;
                }
                i++;
            }
            j++;
        }
        return result;
    }
};
