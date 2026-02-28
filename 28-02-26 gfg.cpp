class Solution {
  public:
    vector<int> findClosestPair(vector<int> &arr1, vector<int> &arr2, int x) {
        int i = 0;
        int j = arr2.size() - 1;
        int minDiff = INT_MAX;
        int a = 0, b = 0;
        while (i < arr1.size() && j >= 0) {
            int sum = arr1[i] + arr2[j];
            int diff = abs(sum - x);
            if (diff < minDiff) {
                minDiff = diff;
                a = arr1[i];
                b = arr2[j];
            }
            if (sum > x) {
                j--;
            } else {
                i++;
            }
        }
        return {a, b};
    }
};
