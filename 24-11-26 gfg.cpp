class Solution {
  public:
    vector<int> findPairs(vector<int>& arr) {
        int n = arr.size();
        unordered_map<int, vector<pair<int, int>>> mp;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                mp[arr[i] + arr[j]].push_back({i, j});
            }
        }
        vector<int> ans = {-1, -1, -1, -1};
        vector<int> deg(n, 0);
        for (auto& entry : mp) {
            auto& vec = entry.second;
            int m = vec.size();
            if (m < 2) continue;
            for (auto& p : vec) {
                deg[p.first]++;
                deg[p.second]++;
            }
            for (int i = 0; i < m; ++i) {
                int u = vec[i].first, v = vec[i].second;
                int covered = deg[u] + deg[v] - 1;
                if (m > covered) {
                    for (int j = i + 1; j < m; ++j) {
                        int x = vec[j].first, y = vec[j].second;
                        if (x != u && x != v && y != u && y != v) {
                            vector<int> cand = {u, v, x, y};
                            if (ans[0] == -1 || cand < ans) {
                                ans = cand;
                            }
                            break;
                        }
                    }
                    break;
                }
            }
            for (auto& p : vec) {
                deg[p.first] = 0;
                deg[p.second] = 0;
            }
        }
        return ans;
    }
};
