class Solution {
    public ArrayList<Integer> minHeightRoot(int V, int[][] edges) {
        ArrayList<Integer> result = new ArrayList<>();
        if (V == 1) {
            result.add(0);
            return result;
        }
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] degree = new int[V];
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            degree[u]++;
            degree[v]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (degree[i] == 1) {
                q.add(i);
            }
        }
        int remaining = V;
        while (remaining > 2) {
            int size = q.size();
            remaining -= size;
            for (int i = 0; i < size; i++) {
                int node = q.poll();
                for (int nei : adj.get(node)) {
                    degree[nei]--;
                    if (degree[nei] == 1) {
                        q.add(nei);
                    }
                }
            }
        }
        while (!q.isEmpty()) {
            result.add(q.poll());
        }
        return result;
    }
}
