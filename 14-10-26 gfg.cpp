class Solution {
public:
    string findRollOut(string& s, vector<int>& roll) {
        int n = s.size();
        vector<int> diff(n + 1, 0);
        for (int r : roll) {
            diff[0]++;
            diff[r]--;
        }
        int shift = 0;
        for (int i = 0; i < n; i++) {
            shift = (shift + diff[i]) % 26;
            if (shift < 0)
                shift += 26;
            s[i] = 'a' + (s[i] - 'a' + shift) % 26;
        }
        return s;
    }
};
