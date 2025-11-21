import java.util.*;
class Solution {
    static class Pair {
        int node, used, dist;
        Pair(int node, int used, int dist) {
            this.node = node;
            this.used = used;
            this.dist = dist;
        }
    }
    public int shortestPath(int V, int a, int b, int[][] edges) {
        @SuppressWarnings("unchecked")
        ArrayList<int[]>[] graph = (ArrayList<int[]>[]) new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<int[]>();
        }
        for (int[] e : edges) {
            int x = e[0], y = e[1], w1 = e[2], w2 = e[3];
            graph[x].add(new int[]{y, w1, w2});
            graph[y].add(new int[]{x, w1, w2});
        }
        int[][] dist = new int[V][2];
        for (int i = 0; i < V; i++) {
            dist[i][0] = dist[i][1] = Integer.MAX_VALUE;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                Comparator.comparingInt(p -> p.dist)
        );
        dist[a][0] = 0;
        pq.add(new Pair(a, 0, 0));
        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int node = cur.node;
            int used = cur.used;
            int d = cur.dist;
            if (d > dist[node][used]) continue;
            for (int[] e : graph[node]) {
                int nbr = e[0];
                int straight = e[1];
                int curved = e[2];
                if (d + straight < dist[nbr][used]) {
                    dist[nbr][used] = d + straight;
                    pq.add(new Pair(nbr, used, dist[nbr][used]));
                }
                if (used == 0 && d + curved < dist[nbr][1]) {
                    dist[nbr][1] = d + curved;
                    pq.add(new Pair(nbr, 1, dist[nbr][1]));
                }
            }
        }
        int ans = Math.min(dist[b][0], dist[b][1]);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
