class Solution {
    public int minThrows(int n, int[] lad, int[] sn) {
        int target = n * n;
        int[] jump = new int[target + 1];
        for (int i = 0; i < lad.length; i += 2) {
            jump[lad[i]] = lad[i + 1];
        }
        for (int i = 0; i < sn.length; i += 2) {
            jump[sn[i]] = sn[i + 1];
        }
        boolean[] visited = new boolean[target + 1];
        java.util.Queue<int[]> q = new java.util.LinkedList<>();
        q.offer(new int[]{1, 0});
        visited[1] = true;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int cell = curr[0];
            int throwsCount = curr[1];
            if (cell == target) {
                return throwsCount;
            }
            for (int dice = 1; dice <= 6; dice++) {
                int next = cell + dice;
                if (next > target) {
                    break;
                }
                if (jump[next] != 0) {
                    next = jump[next];
                }
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(new int[]{next, throwsCount + 1});
                }
            }
        }
        return -1;
    }
}
