class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> res = new ArrayList<>();
        if(adj==null||adj.size()==0)
        return res;
        int n = adj.size();
        boolean[] vis = new boolean[n];
        for(int i=0;i<n;i++)
        {
            if(!vis[i])
            dfsUtils(adj,0,vis,res);
        }
        return res;
    }
    private void dfsUtils(ArrayList<ArrayList<Integer>> adj,int source,
    boolean[] vis,ArrayList<Integer> res)
    {
        res.add(source);
        vis[source] = true;
        for(int neighbour:adj.get(source))
        {
            if(!vis[neighbour])
            dfsUtils(adj,neighbour,vis,res);
        }
    }
}
