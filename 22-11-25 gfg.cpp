class Solution {
public:
    int minConnect(int V, vector<vector<int>>& edges) {
        int E = edges.size();
        if (E < V - 1) return -1;
        vector<int> parent(V), rank(V, 0);
        for (int i = 0; i < V; i++)
            parent[i] = i;
        function<int(int)> find = [&](int x) {
            if (parent[x] == x) return x;
            return parent[x] = find(parent[x]);
        };
        auto unite = [&](int a, int b) {
            a = find(a);
            b = find(b);
            if (a != b) {
                if (rank[a] < rank[b]) swap(a, b);
                parent[b] = a;
                if (rank[a] == rank[b]) rank[a]++;
            }
        };
        for (auto &e : edges)
            unite(e[0], e[1]);
        int components = 0;
        for (int i = 0; i < V; i++)
            if (find(i) == i)
                components++;
        return components - 1;
    }
};
