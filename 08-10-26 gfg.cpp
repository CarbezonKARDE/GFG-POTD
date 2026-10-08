class Solution {
public:
    int maxFrequency(vector<int>& arr, int k) {
        sort(arr.begin(), arr.end());
        long long sum = 0;
        int l = 0;
        int ans = 1;
        for (int r = 0; r < arr.size(); r++) {
            sum += arr[r];
            long long cost = 1LL * arr[r] * (r - l + 1) - sum;
            while (cost > k) {
                sum -= arr[l];
                l++;
                cost = 1LL * arr[r] * (r - l + 1) - sum;
            }
            ans = max(ans, r - l + 1);
        }
        return ans;
    }
};
