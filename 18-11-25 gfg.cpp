#include <vector>
#include <queue>
#include <tuple>
using namespace std;
class Solution {
public:
    int countPaths(int V, vector<vector<int>>& edges) {
        const int MOD = 1e9 + 7;
        vector<pair<int, int>> adj[V];
        for (const auto& edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int time = edge[2];
            adj[u].push_back({v, time});
            adj[v].push_back({u, time});
        }
        vector<long long> dist(V, 1e18); 
        vector<int> ways(V, 0);
        priority_queue<pair<long long, int>, vector<pair<long long, int>>, greater<pair<long long, int>>> pq;
        dist[0] = 0;
        ways[0] = 1;
        pq.push({0, 0});
        while (!pq.empty()) {
            long long t = pq.top().first;
            int u = pq.top().second;
            pq.pop();
            if (t > dist[u]) {
                continue;
            }
            for (auto& edge : adj[u]) {
                int v = edge.first;
                int time_uv = edge.second;
                long long new_time = t + time_uv;
                if (new_time < dist[v]) {
                    dist[v] = new_time;
                    ways[v] = ways[u];
                    pq.push({dist[v], v});
                }
                else if (new_time == dist[v]) {
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }
        return ways[V - 1];
    }
};
