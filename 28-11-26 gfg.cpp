class Solution {
public:
    bool checkPath(vector<vector<int>> &adj, int u, int v) {
        int n = adj.size();
        vector<bool> visited(n, false);
        queue<int> q;
        q.push(u);
        visited[u] = true;
        while (!q.empty()) {
            int node = q.front();
            q.pop();
            if (node == v)
                return true;
            for (int neighbor : adj[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.push(neighbor);
                }
            }
        }
        return false;
    }
};
