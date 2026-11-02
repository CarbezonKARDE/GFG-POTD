class Solution {
public:
    int largestSumCycle(vector<int>& edge) {
        int n = edge.size();
        vector<int> visited(n, 0);
        vector<int> pathIndex(n, -1);
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            vector<int> path;
            int node = i;
            while (node != -1 && !visited[node]) {
                visited[node] = 1;
                pathIndex[node] = path.size();
                path.push_back(node);
                node = edge[node];
            }
            if (node != -1 && pathIndex[node] != -1) {
                int sum = 0;
                for (int j = pathIndex[node]; j < path.size(); j++) {
                    sum += path[j];
                }
                ans = max(ans, sum);
            }
            for (int x : path) {
                pathIndex[x] = -1;
            }
        }
        return ans;
    }
};
