class Solution {
  public:
    int query(vector<int>& bit, int idx) {
        int ans = 0;
        while (idx > 0) {
            ans = max(ans, bit[idx]);
            idx -= idx & -idx;
        }
        return ans;
    }
    void update(vector<int>& bit, int idx, int val) {
        while (idx < bit.size()) {
            bit[idx] = max(bit[idx], val);
            idx += idx & -idx;
        }
    }
    int maxStackHeight(vector<int> &r, vector<int> &h) {
        int n = r.size();
        vector<vector<int>> discs(1001);
        for (int i = 0; i < n; i++) {
            discs[r[i]].push_back(h[i]);
        }
        vector<int> bit(1002, 0);
        int ans = 0;
        for (int radius = 1; radius <= 1000; radius++) {
            vector<pair<int, int>> updates;
            for (int height : discs[radius]) {
                int best = query(bit, height - 1);
                int current = best + height;
                updates.push_back({height, current});
                ans = max(ans, current);
            }
            for (auto &p : updates) {
                update(bit, p.first, p.second);
            }
        }
        return ans;
    }
};
