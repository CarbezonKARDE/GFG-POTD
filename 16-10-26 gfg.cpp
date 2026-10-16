class Solution {
public:
    int countAlwaysFound(vector<int>& arr) {
        int n = arr.size();
        int ans = 0;
        int prefixMax = INT_MIN;
        vector<int> suffixMin(n);
        suffixMin[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            suffixMin[i] = min(arr[i], suffixMin[i + 1]);
        }
        for (int i = 0; i < n; ++i) {
            if (arr[i] > prefixMax && arr[i] == suffixMin[i]) {
                ++ans;
            }
            prefixMax = max(prefixMax, arr[i]);
        }
        return ans;
    }
};
