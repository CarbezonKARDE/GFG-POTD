class Solution {
  public:
    int longestSubarray(vector<int> &arr, int k) {
        int n = arr.size();
        unordered_map<int, int> prefixIndex;
        int prefixSum = 0, maxLen = 0;
        for (int i = 0; i < n; ++i) {
            if (arr[i] > k)
                prefixSum += 1;
            else
                prefixSum -= 1;
            if (prefixSum > 0) {
                maxLen = i + 1;
            } else {
                if (prefixIndex.find(prefixSum - 1) != prefixIndex.end()) {
                    maxLen = max(maxLen, i - prefixIndex[prefixSum - 1]);
                }
            }
            if (prefixIndex.find(prefixSum) == prefixIndex.end()) {
                prefixIndex[prefixSum] = i;
            }
        }
        return maxLen;
    }
};
