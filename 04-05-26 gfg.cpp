class Solution {
  public:
    int isPallindrome(long long int N) {
        int left = 63;
        while (left >= 0 && ((N >> left) & 1) == 0) {
            left--;
        }
        int right = 0;
        while (left > right) {
            int leftBit = (N >> left) & 1;
            int rightBit = (N >> right) & 1;
            if (leftBit != rightBit)
                return 0;
            left--;
            right++;
        }
        return 1;
    }
};
