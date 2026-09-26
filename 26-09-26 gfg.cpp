class Solution {
public:
    int minimumCost(int x, int s, int m, int l, int cs, int cm, int cl) {
        const int INF = 1e9;
        int maxArea = x + l;
        vector<int> dp(maxArea + 1, INF);
        dp[0] = 0;
        for (int area = 1; area <= maxArea; area++) {
            if (area >= s)
                dp[area] = min(dp[area], dp[area - s] + cs);
            if (area >= m)
                dp[area] = min(dp[area], dp[area - m] + cm);
            if (area >= l)
                dp[area] = min(dp[area], dp[area - l] + cl);
        }
        int ans = INF;
        for (int area = x; area <= maxArea; area++) {
            ans = min(ans, dp[area]);
        }
        return ans;
    }
};
