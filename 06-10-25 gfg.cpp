class Solution {
  public:
    int dx[8] = {2, 1, -1, -2, -2, -1, 1, 2};
    int dy[8] = {1, 2, 2, 1, -1, -2, -2, -1};
    bool isSafe(int x, int y, int n, vector<vector<int>> &board) {
        return (x >= 0 && y >= 0 && x < n && y < n && board[x][y] == -1);
    }
    bool solve(int x, int y, int move, int n, vector<vector<int>> &board) {
        if (move == n * n) return true;
        for (int k = 0; k < 8; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (isSafe(nx, ny, n, board)) {
                board[nx][ny] = move;
                if (solve(nx, ny, move + 1, n, board))
                    return true;
                board[nx][ny] = -1;
            }
        }
        return false;
    }
    vector<vector<int>> knightTour(int n) {
        vector<vector<int>> board(n, vector<int>(n, -1));
        board[0][0] = 0;
        if (!solve(0, 0, 1, n, board))
            return {};
        return board;
    }
};
