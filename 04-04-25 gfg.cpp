class Solution {
  public:
bool dfs(vector<vector<int>>& adj, vector<bool>& visited, int s, int p) {
    visited[s] = true;
    for (auto x : adj[s]) {
        if (!visited[x]) {
            if (dfs(adj, visited, x, s)) {
                return true;
            }
        }
        else if (x != p) {
            return true;
        }
    }
    return false;
}
bool isCycle(int V, vector<vector<int>>& edges) {
    vector<vector<int>> adj(V);
    for (auto edge : edges) {
        int u = edge[0], v = edge[1];
        adj[u].push_back(v);
        adj[v].push_back(u);
    }
    vector<bool> visited(V, false);
    for (int i = 0; i < V; i++) {
        if (!visited[i] && dfs(adj, visited, i, -1)) {
            return true;
        }
    }
    return false;
}
};
