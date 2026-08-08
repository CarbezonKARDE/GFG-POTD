class Solution {
public:
    vector<int> parent, rankv;
    int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }
    void unite(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b)
            return;
        if (rankv[a] < rankv[b])
            swap(a, b);
        parent[b] = a;
        if (rankv[a] == rankv[b])
            rankv[a]++;
    }
    int minEdgesReq(int n, vector<vector<int>>& edges) {
        int m = edges.size();
        if (m < n - 1)
            return -1;
        parent.resize(n);
        rankv.assign(n, 0);
        for (int i = 0; i < n; i++)
            parent[i] = i;
        for (auto& edge : edges) {
            unite(edge[0], edge[1]);
        }
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (find(i) == i)
                components++;
        }
        return components - 1;
    }
};
