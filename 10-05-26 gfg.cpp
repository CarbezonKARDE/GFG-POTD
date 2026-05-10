class Solution {
  public:
    int maxProfit(int x, int y, vector<int> &a, vector<int> &b) {
        int n = a.size();
        vector<pair<int,int>> diff;
        for(int i = 0; i < n; i++) {
            diff.push_back({abs(a[i] - b[i]), i});
        }
        sort(diff.begin(), diff.end(), greater<pair<int,int>>());
        int profit = 0;
        for(auto &p : diff) {
            int i = p.second;
            if((a[i] >= b[i] && x > 0) || y == 0) {
                profit += a[i];
                x--;
            } else {
                profit += b[i];
                y--;
            }
        }
        return profit;
    }
};
