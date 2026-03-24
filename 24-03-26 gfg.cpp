class Solution {
  public:
    bool canFinish(int n, vector<vector<int>>& prerequisites) {
        vector<vector<int>> adj(n);
        vector<int> indegree(n, 0);
        for(auto &p : prerequisites) {
            int x = p[0], y = p[1];
            adj[y].push_back(x);  // y -> x
            indegree[x]++;
        }
        queue<int> q;
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) {
                q.push(i);
            }
        }
        int count = 0;
        while(!q.empty()) {
            int node = q.front();
            q.pop();
            count++;
            for(auto &nbr : adj[node]) {
                indegree[nbr]--;
                if(indegree[nbr] == 0) {
                    q.push(nbr);
                }
            }
        }
        return count == n;
    }
};
