class Solution {
  public:
    int countMinOperations(vector<int>& arr) {
        int increments = 0;
        int doubles = 0;
        for (int x : arr) {
            increments += __builtin_popcount((unsigned int)x);
            if (x > 0) {
                int bits = 0;
                while (x > 1) {
                    x >>= 1;
                    bits++;
                }
                doubles = max(doubles, bits);
            }
        }
        return increments + doubles;
    }
};
