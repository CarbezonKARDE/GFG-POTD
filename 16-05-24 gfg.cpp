class Solution {
  public:
    int dfs(int i, vector<vector<int>>& adj, vector<int>& vis, int& ans){
        int count= 1;
        vis[i]= 1;
        for (auto child: adj[i]){
            if (vis[child]==0){
                int child_node= dfs(child,adj,vis,ans);
                if (child_node%2==0)ans++;
                else count+= child_node;
            }
        }
        return count;
    }
    int maxEdgeRemoval(int n, vector<vector<int>> &edges) {
        // Code here
        int ans=0;
        vector<vector<int>> adj(n);
        for (auto edge: edges){
            adj[edge[0]-1].push_back(edge[1]-1);
            adj[edge[1]-1].push_back(edge[0]-1);
        }
        vector<int> vis(n,0);
        dfs(0,adj,vis,ans);
        
        return ans;
    }
};
