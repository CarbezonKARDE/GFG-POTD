class Solution {
  public:
    int countCoordinates(vector<vector<int>>& mat) {
        int n = mat.size(), m = mat[0].size();
        vector<vector<int>> p(n, vector<int>(m, 0));
        vector<vector<int>> q(n, vector<int>(m, 0));
        queue<pair<int,int>> qp, qq;
        for (int i = 0; i < n; i++) {
            if (!p[i][0]) {
                p[i][0] = 1;
                qp.push({i, 0});
            }
        }
        for (int j = 0; j < m; j++) {
            if (!p[0][j]) {
                p[0][j] = 1;
                qp.push({0, j});
            }
        }
        for (int i = 0; i < n; i++) {
            if (!q[i][m - 1]) {
                q[i][m - 1] = 1;
                qq.push({i, m - 1});
            }
        }
        for (int j = 0; j < m; j++) {
            if (!q[n - 1][j]) {
                q[n - 1][j] = 1;
                qq.push({n - 1, j});
            }
        }
        int dr[4] = {-1, 1, 0, 0};
        int dc[4] = {0, 0, -1, 1};
        auto bfs = [&](queue<pair<int,int>>& qu, vector<vector<int>>& vis) {
            while (!qu.empty()) {
                auto [r, c] = qu.front();
                qu.pop();
                for (int k = 0; k < 4; k++) {
                    int nr = r + dr[k], nc = c + dc[k];
                    if (nr >= 0 && nr < n && nc >= 0 && nc < m &&
                        !vis[nr][nc] &&
                        mat[nr][nc] >= mat[r][c]) {
                        vis[nr][nc] = 1;
                        qu.push({nr, nc});
                    }
                }
            }
        };
        bfs(qp, p);
        bfs(qq, q);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (p[i][j] && q[i][j]) ans++;
            }
        }
        return ans;
    }
};
