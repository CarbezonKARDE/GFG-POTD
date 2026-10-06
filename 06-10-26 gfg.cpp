class Solution {
  public:
    int longIncPath(vector<vector<int>> &matrix, int n, int m) {
        vector<vector<int>> indegree(n, vector<int>(m, 0));
        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, -1, 1};
        queue<pair<int, int>> q;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int d = 0; d < 4; d++) {
                    int x = i + dx[d];
                    int y = j + dy[d];
                    if (x >= 0 && x < n &&
                        y >= 0 && y < m &&
                        matrix[x][y] > matrix[i][j]) {
                        indegree[x][y]++;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (indegree[i][j] == 0) {
                    q.push({i, j});
                }
            }
        }
        int length = 0;
        while (!q.empty()) {
            int sz = q.size();
            length++;
            while (sz--) {
                auto [i, j] = q.front();
                q.pop();
                for (int d = 0; d < 4; d++) {
                    int x = i + dx[d];
                    int y = j + dy[d];
                    if (x >= 0 && x < n &&
                        y >= 0 && y < m &&
                        matrix[x][y] > matrix[i][j]) {
                        indegree[x][y]--;
                        if (indegree[x][y] == 0) {
                            q.push({x, y});
                        }
                    }
                }
            }
        }
        return length;
    }
};
