#include <vector>
#include <queue>
using namespace std;
class Solution {
  public:
    int maxEdgesToAdd(int V, vector<vector<int>>& edges) {
        vector<int> indegree(V, 0);
        vector<vector<int>> adj(V);
        for (auto& edge : edges) {
            int u = edge[0], v = edge[1];
            adj[u].push_back(v);
            indegree[v]++;
        }
        queue<int> q;
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.push(i);
            }
        }
        vector<int> topo;
        while (!q.empty()) {
            int node = q.front();
            q.pop();
            topo.push_back(node);

            for (int neighbor : adj[node]) {
                if (--indegree[neighbor] == 0) {
                    q.push(neighbor);
                }
            }
        }
        int maxPossibleEdges = V * (V - 1) / 2;
        int currentEdges = edges.size();
        return maxPossibleEdges - currentEdges;
    }
};
