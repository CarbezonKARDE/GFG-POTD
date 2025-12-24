class Solution {
public:
    int countLessEqual(vector<int>& arr, int x) {
        int n = arr.size();
        int low = 0, high = n - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > arr[high])
                low = mid + 1;
            else
                high = mid;
        }
        int pivot = low;
        auto countInRange = [&](int l, int r) {
            int lo = l, hi = r;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (arr[mid] <= x)
                    lo = mid + 1;
                else
                    hi = mid - 1;
            }
            return hi - l + 1;
        };
        int count = 0;
        if (pivot > 0)
            count += countInRange(0, pivot - 1);
        count += countInRange(pivot, n - 1);
        return count;
    }
};
