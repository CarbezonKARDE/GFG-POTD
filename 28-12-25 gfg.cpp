class Solution {
  public:
    bool canMake(vector<int>& ranks, int n, int T) {
        int donuts = 0;
        for (int r : ranks) {
            int time = 0;
            int k = 1;
            while (true) {
                time += r * k;
                if (time > T) break;
                donuts++;
                if (donuts >= n) return true;
                k++;
            }
        }
        return false;
    }
    int minTime(vector<int>& ranks, int n) {
        int low = 0;
        int high = (*min_element(ranks.begin(), ranks.end())) 
                    * (n * (n + 1) / 2);
        int ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (canMake(ranks, n, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
};
