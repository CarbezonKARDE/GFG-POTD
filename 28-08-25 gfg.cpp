class Solution {
  public:
    int maxOnes(vector<int>& arr, int k) {
        int n = arr.size();
        int left = 0, right = 0;
        int zeroCount = 0, maxLen = 0;
        while (right < n) {
            if (arr[right] == 0) zeroCount++;
            while (zeroCount > k) {
                if (arr[left] == 0) zeroCount--;
                left++;
            }
            maxLen = max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
};
