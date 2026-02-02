class Solution {
  public:
    int maxCircularSum(vector<int> &arr) {
        int n = arr.size();
        int totalSum = 0;
        int maxKadane = arr[0];
        int currMax = arr[0];
        int minKadane = arr[0];
        int currMin = arr[0];
        totalSum = arr[0];
        for (int i = 1; i < n; i++) {
            int x = arr[i];
            currMax = max(x, currMax + x);
            maxKadane = max(maxKadane, currMax);
            currMin = min(x, currMin + x);
            minKadane = min(minKadane, currMin);
            totalSum += x;
        }
        if (maxKadane < 0)
            return maxKadane;
        int maxCircular = totalSum - minKadane;
        return max(maxKadane, maxCircular);
    }
};
