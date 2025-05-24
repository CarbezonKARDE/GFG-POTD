class Solution {
  public:
    int sumSubstrings(string &s) {
        int n = s.length();
        long long result = 0;
        long long prev = 0;
        int mod = 1000000007;
        for (int i = 0; i < n; i++) {
            int num = s[i] - '0';
            prev = prev * 10 + num * (i + 1);
            result += prev;
        }
        return (int)result;
    }
};
