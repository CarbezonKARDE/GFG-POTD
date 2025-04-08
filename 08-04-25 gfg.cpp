class Solution {
  public:
    void dfs(int node, vector<int> adj[], vector<bool> &visited) {
        visited[node] = true;
        for (int neighbor : adj[node]) {
            if (!visited[neighbor])
                dfs(neighbor, adj, visited);
        }
    }
    bool isBridge(int V, vector<vector<int>> &edges, int c, int d) {
        vector<int> adj[V];
        for (auto &edge : edges) {
            int u = edge[0], v = edge[1];
            adj[u].push_back(v);
            adj[v].push_back(u);
        }
        vector<bool> visited(V, false);
        int initial_components = 0;
        for (int i = 0; i < V; ++i) {
            if (!visited[i]) {
                ++initial_components;
                dfs(i, adj, visited);
            }
        }
        adj[c].erase(remove(adj[c].begin(), adj[c].end(), d), adj[c].end());
        adj[d].erase(remove(adj[d].begin(), adj[d].end(), c), adj[d].end());
        fill(visited.begin(), visited.end(), false);
        int components_after_removal = 0;
        for (int i = 0; i < V; ++i) {
            if (!visited[i]) {
                ++components_after_removal;
                dfs(i, adj, visited);
            }
        }
        return components_after_removal > initial_components;
    }
};
