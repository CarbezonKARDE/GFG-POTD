import java.util.*;
class Solution {
    public int diameter(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        int[] firstBFS = bfs(0, adj, V);
        int farthest1 = firstBFS[0];
        int[] secondBFS = bfs(farthest1, adj, V);
        int diameter = secondBFS[1];
        return diameter;
    }
    private int[] bfs(int start, List<List<Integer>> adj, int V) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[V];
        int[] dist = new int[V];
        q.offer(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int nei : adj.get(node)) {
                if (!visited[nei]) {
                    visited[nei] = true;
                    dist[nei] = dist[node] + 1;
                    q.offer(nei);
                }
            }
        }
        int maxNode = start, maxDist = 0;
        for (int i = 0; i < V; i++) {
            if (dist[i] > maxDist) {
                maxDist = dist[i];
                maxNode = i;
            }
        }
        return new int[]{maxNode, maxDist}; // [node, distance]
    }
}
