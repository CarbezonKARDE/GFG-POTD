class Solution {
  public:
    char nthCharacter(int n) {
        long long digits = 1;
        long long count = 9;
        long long start = 1;
        while (n > digits * count) {
            n -= digits * count;
            digits++;
            count *= 10;
            start *= 10;
        }
        long long number = start + (n - 1) / digits;
        int index = (n - 1) % digits;
        string str = to_string(number);
        return str[index];
    }
};
