class Solution {
public:
    int minMen(vector<int>& arr) {
        int n = arr.size();
        vector<pair<int,int>> intervals;
        for (int i = 0; i < n; i++) {
            if (arr[i] == -1) continue;
            int L = max(0, i - arr[i]);
            int R = min(n - 1, i + arr[i]);
            intervals.push_back({L, R});
        }
        sort(intervals.begin(), intervals.end());
        int covered_until = 0;
        int idx = 0;
        int cnt = 0;
        while (covered_until < n) {
            int best_reach = covered_until;
            while (idx < (int)intervals.size() && intervals[idx].first <= covered_until) {
                best_reach = max(best_reach, intervals[idx].second + 1);
                idx++;
            }
            if (best_reach == covered_until) return -1;
            covered_until = best_reach;
            cnt++;
        }
        return cnt;
    }
};
