class Solution {
  public:
    int maxFruits(vector<int>& arr, int m) {
        int n = arr.size();
        if (m >= n) {
            long long total = 0;
            for (int x : arr) total += x;
            return total;
        }
        long long curr = 0;
        for (int i = 0; i < m; i++) {
            curr += arr[i];
        }
        long long ans = curr;
        for (int i = 1; i < n; i++) {
            curr -= arr[i - 1];
            curr += arr[(i + m - 1) % n];
            ans = max(ans, curr);
        }
        return ans;
    }
};
