import java.util.*;
class Solution {
    public int minimumEdgeReversal(int[][] edges, int n, int src, int dst) {
        List<int[]>[] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj[u].add(new int[]{v, 0});
            adj[v].add(new int[]{u, 1});
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Deque<Integer> dq = new ArrayDeque<>();
        dist[src] = 0;
        dq.offerFirst(src);
        while (!dq.isEmpty()) {
            int u = dq.pollFirst();
            for (int[] next : adj[u]) {
                int v = next[0];
                int cost = next[1];
                if (dist[u] + cost < dist[v]) {
                    dist[v] = dist[u] + cost;
                    if (cost == 0) {
                        dq.offerFirst(v);
                    } else {
                        dq.offerLast(v);
                    }
                }
            }
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
