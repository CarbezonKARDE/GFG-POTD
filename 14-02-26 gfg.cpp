class Solution {
public:
    bool canPaint(vector<int>& arr, int k, long long maxTime) {
        int painters = 1;
        long long curr = 0;
        for (int board : arr) {
            if (curr + board <= maxTime) {
                curr += board;
            } else {
                painters++;
                curr = board;

                if (painters > k)
                    return false;
            }
        }
        return true;
    }
    int minTime(vector<int>& arr, int k) {
        long long low = 0, high = 0;
        for (int x : arr) {
            low = max(low, (long long)x);
            high += x;
        }
        long long ans = high;
        while (low <= high) {
            long long mid = low + (high - low) / 2;
            if (canPaint(arr, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int)ans;
    }
};
