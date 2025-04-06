class Solution {
  public:
    vector<int> topoSort(int V, vector<vector<int>>& edges) {
        vector<vector<int>> adj(V);
        vector<int> freq(V,0);
        for(auto x : edges){
            adj[x[0]].push_back(x[1]);
            freq[x[1]]++;
        }
        queue<int> q;
        for(int i=0;i<V;i++){
            if(freq[i]==0)
                q.push(i);
            
        }
        vector<int> ans;
        while(!q.empty()){
            int z = q.front();
            q.pop();
            ans.push_back(z);
            for(auto xx : adj[z]){
                freq[xx]--;
                if(freq[xx]==0)
                    q.push(xx);
            }
        }
        return ans;
    }
};
