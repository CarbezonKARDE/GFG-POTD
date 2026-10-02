class Solution {
    public int minTime(int[] duration, int[][] dependencies) {
        int n = duration.length;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for (int[] edge : dependencies) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            indegree[v]++;
        }
        long[] finish = new long[n];
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
                finish[i] = duration[i];
            }
        }
        int count = 0;
        long answer = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            count++;
            answer = Math.max(answer, finish[u]);
            for (int v : graph.get(u)) {
                finish[v] = Math.max(
                    finish[v],
                    finish[u] + duration[v]
                );
                indegree[v]--;
                if (indegree[v] == 0) {
                    q.offer(v);
                }
            }
        }
        if (count != n) {
            return -1;
        }
        return (int) answer;
    }
}
