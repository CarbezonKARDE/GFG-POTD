class Solution {
public:
    int countPairs(vector<int>& arr, int k) {
        if (k <= 0) return 0;
        sort(arr.begin(), arr.end());
        int n = arr.size();
        long long ans = 0;
        int j = 1;
        for (int i = 0; i < n; i++) {
            if (j < i + 1) j = i + 1;
            while (j < n && arr[j] - arr[i] < k) {
                j++;
            }
            ans += (j - i - 1);
        }
        return (int)ans;
    }
};
