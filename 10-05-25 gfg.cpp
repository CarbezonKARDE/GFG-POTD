class Solution {
public:
    int longestSubarray(vector<int> &arr, int k) {
        vector<int> transformed;
        for (int num : arr) {
            transformed.push_back(num > k ? 1 : -1);
        }
        unordered_map<int, int> prefixIndex;
        int prefixSum = 0;
        int maxLen = 0;
        for (int i = 0; i < transformed.size(); ++i) {
            prefixSum += transformed[i];
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
