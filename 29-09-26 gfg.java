import java.util.*;
class Solution {
    public int minStepToReachTarget(int knightPos[], int targetPos[], int n) {
        int[][] moves = {
            {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
            {1, 2}, {1, -2}, {-1, 2}, {-1, -2}
        };
        int sx = knightPos[0] - 1;
        int sy = knightPos[1] - 1;
        int tx = targetPos[0] - 1;
        int ty = targetPos[1] - 1;
        if (sx == tx && sy == ty)
            return 0;
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sx, sy, 0});
        visited[sx][sy] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int steps = cur[2];
            for (int[] move : moves) {
                int nx = x + move[0];
                int ny = y + move[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n
                        && !visited[nx][ny]) {
                    if (nx == tx && ny == ty)
                        return steps + 1;
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny, steps + 1});
                }
            }
        }
        return -1;
    }
}
