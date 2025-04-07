class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }
        boolean[] visited = new boolean[V];
        boolean[] recursionStack = new boolean[V];        
        for (int i = 0; i < V; i++) {
            if (!visited[i] && dfsDetectCycle(i, adj, visited, recursionStack)) {
                return true;
            }
        }
        return false;
    }
    private static boolean dfsDetectCycle(int node, List<List<Integer>> adj, 
                                        boolean[] visited, boolean[] recursionStack) {
        if (recursionStack[node]) {
            return true;
        }        
        if (visited[node]) {
            return false;
        }
        visited[node] = true;
        recursionStack[node] = true;
        for (int neighbor : adj.get(node)) {
            if (dfsDetectCycle(neighbor, adj, visited, recursionStack)) {
                return true;
            }
        }
        recursionStack[node] = false;
        return false;
    }
}
