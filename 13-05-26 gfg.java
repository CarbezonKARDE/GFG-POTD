class Solution {
    public int findMotherVertex(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] e : edges) {
            adj.get(e[0]).add(e[1]);
        }
        boolean[] vis = new boolean[V];
        int candidate = -1;
        for(int i = 0; i < V; i++) {
            if(!vis[i]) {
                dfs(i, adj, vis);
                candidate = i;
            }
        }
        Arrays.fill(vis, false);
        dfs(candidate, adj, vis);
        for(boolean v : vis) {
            if(!v) return -1;
        }
        for(int i = 0; i < candidate; i++) {
            Arrays.fill(vis, false);
            dfs(i, adj, vis);
            boolean ok = true;
            for(boolean v : vis) {
                if(!v) {
                    ok = false;
                    break;
                }
            }
            if(ok) return i;
        }
        return candidate;
    }
    private void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[node] = true;
        for(int nei : adj.get(node)) {
            if(!vis[nei]) {
                dfs(nei, adj, vis);
            }
        }
    }
}
