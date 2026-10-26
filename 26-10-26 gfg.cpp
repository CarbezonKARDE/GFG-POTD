class Solution {
  public:
    int minDiff(int k, vector<int> &arr) {
        int n = arr.size();
        if (k == 0) {
            return *max_element(arr.begin(), arr.end()) -
                   *min_element(arr.begin(), arr.end());
        }
        vector<int> prefixMin(n), prefixMax(n);
        vector<int> suffixMin(n), suffixMax(n);
        prefixMin[0] = prefixMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixMin[i] = min(prefixMin[i - 1], arr[i]);
            prefixMax[i] = max(prefixMax[i - 1], arr[i]);
        }
        suffixMin[n - 1] = suffixMax[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = min(suffixMin[i + 1], arr[i]);
            suffixMax[i] = max(suffixMax[i + 1], arr[i]);
        }
        int ans = INT_MAX;
        for (int i = 0; i <= n - k; i++) {
            int mn = INT_MAX;
            int mx = INT_MIN;
            if (i > 0) {
                mn = min(mn, prefixMin[i - 1]);
                mx = max(mx, prefixMax[i - 1]);
            }
            if (i + k < n) {
                mn = min(mn, suffixMin[i + k]);
                mx = max(mx, suffixMax[i + k]);
            }
            if (mn == INT_MAX) {
                ans = 0;
            } else {
                ans = min(ans, mx - mn);
            }
        }
        return ans;
    }
};
