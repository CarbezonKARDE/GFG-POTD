class Solution {
public:
    string stringAdd(string a, string b) {
        string result = "";
        int carry = 0;
        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0 || carry) {
            int sum = carry;
            if (i >= 0) sum += a[i--] - '0';
            if (j >= 0) sum += b[j--] - '0';
            result = char(sum % 10 + '0') + result;
            carry = sum / 10;
        }
        return result;
    }
    bool checkSum(string s, int start, string a, string b) {
        string sum = stringAdd(a, b);
        int len = sum.length();
        if (start + len > s.length()) return false;
        if (s.substr(start, len) != sum) return false;
        if (start + len == s.length()) return true;
        return checkSum(s, start + len, b, sum);
    }
    bool isSumString(string &s) {
        int n = s.length();
        for (int i = 1; i < n; ++i) {
            for (int j = 1; i + j < n; ++j) {
                string a = s.substr(0, i);
                string b = s.substr(i, j);
                if ((a.length() > 1 && a[0] == '0') || (b.length() > 1 && b[0] == '0'))
                    continue;
                if (checkSum(s, i + j, a, b)) return true;
            }
        }
        return false;
    }
};
