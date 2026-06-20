class Solution {
public:
    int getLastDigit(string& a, string& b) {
        if (b == "0")
            return 1;
        int base = a.back() - '0';
        int expMod4 = 0;
        for (char c : b) {
            expMod4 = (expMod4 * 10 + (c - '0')) % 4;
        }
        if (expMod4 == 0)
            expMod4 = 4;
        int result = 1;
        for (int i = 0; i < expMod4; i++) {
            result = (result * base) % 10;
        }
        return result;
    }
};
