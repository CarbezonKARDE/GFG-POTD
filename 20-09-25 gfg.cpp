#include <bits/stdc++.h>
using namespace std;
class Solution {
public:
    int longestSubarray(vector<int>& arr) {
        int n = arr.size();
        if (n == 0) return 0;
        vector<vector<int>> pos(n + 1);
        for (int i = 0; i < n; ++i) {
            if (arr[i] <= n) pos[arr[i]].push_back(i);
        }
        vector<int> parent(n), sz(n, 0);
        vector<char> active(n, 0);
        for (int i = 0; i < n; ++i) parent[i] = i;

        function<int(int)> findp = [&](int x) -> int {
            return parent[x] == x ? x : parent[x] = findp(parent[x]);
        };
        auto unite = [&](int a, int b) {
            a = findp(a); b = findp(b);
            if (a == b) return;
            if (sz[a] < sz[b]) swap(a, b);
            parent[b] = a;
            sz[a] += sz[b];
        };
        int best = 0;
        int maxSeg = 0;
        for (int L = 1; L <= n; ++L) {
            for (int idx : pos[L]) {
                active[idx] = 1;
                parent[idx] = idx;
                sz[idx] = 1;
                if (idx - 1 >= 0 && active[idx - 1]) unite(idx, idx - 1);
                if (idx + 1 < n && active[idx + 1]) unite(idx, idx + 1);
                maxSeg = max(maxSeg, sz[findp(idx)]);
            }
            if (maxSeg >= L) best = max(best, L);
        }
        return best;
    }
};
