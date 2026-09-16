class Solution {
  public:
    int dominantPairs(vector<int> &arr) {
        int n = arr.size();
        int mid = n / 2;
        vector<int> second(arr.begin() + mid, arr.end());
        sort(second.begin(), second.end());
        long long ans = 0;
        for (int i = 0; i < mid; i++) {
            int limit = arr[i] / 5;
            int low = 0, high = second.size();
            while (low < high) {
                int m = low + (high - low) / 2;
                if ((long long)arr[i] >= 5LL * second[m])
                    low = m + 1;
                else
                    high = m;
            }
            ans += low;
        }
        return (int)ans;
    }
};
