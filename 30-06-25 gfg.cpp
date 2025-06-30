class Solution {
public:
    bool canAchieve(vector<int> &arr, int k, int w, int target) {
        int n = arr.size();
        vector<int> water(n + 1, 0);
        long long ops = 0, currWater = 0;

        for (int i = 0; i < n; ++i) {
            currWater += water[i];
            int height = arr[i] + currWater;
            if (height < target) {
                int add = target - height;
                ops += add;
                if (ops > k) return false;
                currWater += add;
                if (i + w < n) water[i + w] -= add;
            }
        }
        return true;
    }

    int maxMinHeight(vector<int> &arr, int k, int w) {
        int low = *min_element(arr.begin(), arr.end());
        int high = low + k;
        int ans = low;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canAchieve(arr, k, w, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
};
