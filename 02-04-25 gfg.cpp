class Solution {
  public:
    vector<int> bfs(vector<vector<int>> &adj) {
        vector<int> ans ;
        int n = adj.size() ;
        vector<int> visited(n) ;
        queue<int> q ;
        q.push(0) ;
        visited[0]=1 ;
        while(!q.empty()){
            int node = q.front() ;
            q.pop(); 
            ans.push_back(node) ;
            for(auto neighbour : adj[node]){
                if(visited[neighbour]==0){
                    q.push(neighbour) ;
                    visited[neighbour]=1 ;
                }
            }
        }
        return ans ;
    }
};
