class Solution {
    int n, m;
    int ans = -1;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    public int longestPath(int[][] mat, int xs, int ys, int xd, int yd) {
        n = mat.length;
        m = mat[0].length;
        if (mat[xs][ys] == 0 || mat[xd][yd] == 0)
            return -1;
        boolean[][] vis = new boolean[n][m];
        dfs(mat, xs, ys, xd, yd, vis, 0);
        return ans;
    }
    private void dfs(int[][] mat, int r, int c, int xd, int yd, boolean[][] vis, int len) {
        if (r == xd && c == yd) {
            ans = Math.max(ans, len);
            return;
        }
        vis[r][c] = true;
        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (nr >= 0 && nr < n && nc >= 0 && nc < m &&
                mat[nr][nc] == 1 && !vis[nr][nc]) {
                dfs(mat, nr, nc, xd, yd, vis, len + 1);
            }
        }
        vis[r][c] = false;
    }
}
