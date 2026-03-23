class Solution {
    public int longestCycle(int V, int[][] edges) {
        int[] next = new int[V];
        for (int i = 0; i < V; i++) next[i] = -1;
        for (int[] e : edges) {
            next[e[0]] = e[1];
        }
        int[] vis = new int[V];
        int[] time = new int[V];
        int traversalId = 1;
        int ans = -1;
        for (int i = 0; i < V; i++) {
            if (vis[i] != 0) continue;
            int curr = i;
            int step = 0;
            while (curr != -1 && vis[curr] == 0) {
                vis[curr] = traversalId;
                time[curr] = step++;
                curr = next[curr];
            }
            if (curr != -1 && vis[curr] == traversalId) {
                ans = Math.max(ans, step - time[curr]);
            }
            traversalId++;
        }
        return ans;
    }
}
