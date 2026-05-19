class Solution {
    public int minSteps(int[] arr, int start, int end) {
        if(start == end) return 0;
        int MOD = 1000;
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[MOD];
        q.offer(new int[]{start, 0});
        visited[start] = true;
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int num = curr[0];
            int steps = curr[1];
            for(int x : arr) {
                int next = (num * x) % MOD;
                if(next == end) {
                    return steps + 1;
                }
                if(!visited[next]) {
                    visited[next] = true;
                    q.offer(new int[]{next, steps + 1});
                }
            }
        }
        return -1;
    }
}
