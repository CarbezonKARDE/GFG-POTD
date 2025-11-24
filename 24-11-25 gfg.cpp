import java.util.*;
class Solution {
    static class DSU {
        int[] parent, rank;
        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }
        boolean unite(int a, int b) {
            a = find(a);
            b = find(b);
            if (a == b) return false;
            if (rank[a] < rank[b]) {
                int t = a; a = b; b = t;
            }
            parent[b] = a;
            if (rank[a] == rank[b]) rank[a]++;
            return true;
        }
    }
    static class Edge {
        int u, v, w, id;
        Edge(int u, int v, int w, int id) {
            this.u = u;
            this.v = v;
            this.w = w;
            this.id = id;
        }
    }
    public int secondMST(int V, int[][] edges) {
        int E = edges.length;
        if (E < V - 1) return -1;
        Edge[] arr = new Edge[E];
        for (int i = 0; i < E; i++) {
            arr[i] = new Edge(edges[i][0], edges[i][1], edges[i][2], i);
        }
        Arrays.sort(arr, (a, b) -> a.w - b.w);
        DSU dsu = new DSU(V);
        boolean[] used = new boolean[E];
        int mstWeight = 0;
        int cnt = 0;
        for (Edge e : arr) {
            if (dsu.unite(e.u, e.v)) {
                mstWeight += e.w;
                used[e.id] = true;
                cnt++;
            }
        }
        if (cnt != V - 1) return -1;
        int ans = Integer.MAX_VALUE;
        for (int banned = 0; banned < E; banned++) {
            if (!used[banned]) continue;
            DSU d2 = new DSU(V);
            int w2 = 0;
            int c2 = 0;
            for (Edge e : arr) {
                if (e.id == banned) continue;
                if (d2.unite(e.u, e.v)) {
                    w2 += e.w;
                    c2++;
                }
            }
            if (c2 == V - 1 && w2 > mstWeight && w2 < ans) {
                ans = w2;
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
