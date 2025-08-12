class Solution {
  public:
    vector<int> minMaxCandy(vector<int>& prices, int k) {
        sort(prices.begin(), prices.end());
        int n = prices.size();
        long long minCost = 0, maxCost = 0;
        int l = 0, r = n - 1;
        while (l <= r) {
            minCost += prices[l];
            l++;
            r -= k;
        }
        l = 0; r = n - 1;
        while (l <= r) {
            maxCost += prices[r];
            r--;
            l += k;
        }
        return { (int)minCost, (int)maxCost };
    }
};
