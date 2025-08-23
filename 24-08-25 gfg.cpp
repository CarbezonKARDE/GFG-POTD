class Solution {
  public:
    bool canMake(vector<int>& arr, int day, int m, int k) {
        int count = 0, bouquets = 0;
        for (int x : arr) {
            if (x <= day) {
                count++;
                if (count == k) {
                    bouquets++;
                    count = 0;
                }
            } else {
                count = 0;
            }
        }
        return bouquets >= m;
    }
    int minDaysBloom(vector<int>& arr, int k, int m) {
        long long total = 1LL * m * k;
        if (total > arr.size()) return -1;
        int low = *min_element(arr.begin(), arr.end());
        int high = *max_element(arr.begin(), arr.end());
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canMake(arr, mid, m, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
};
