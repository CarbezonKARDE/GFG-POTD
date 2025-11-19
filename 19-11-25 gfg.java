class Solution {
    public int minCostPath(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int low = 0, high = 1_000_000;
        while (low < high) {
            int mid = (low + high) / 2;
            if (canReach(mat, n, m, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    private boolean canReach(int[][] mat, int n, int m, int limit) {
        boolean[][] visited = new boolean[n][m];
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visited[0][0] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            if (x == n - 1 && y == m - 1) return true;
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny]) {
                    int diff = Math.abs(mat[x][y] - mat[nx][ny]);
                    if (diff <= limit) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
        return false;
    }
}
