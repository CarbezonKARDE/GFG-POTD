class Solution {
  public:
    vector<int> exitPoint(vector<vector<int>>& mat) {
        int n = mat.size();
        int m = mat[0].size();
        int r = 0, c = 0;
        int dir = 0;
        while (true) {
            if (mat[r][c] == 1) {
                dir = (dir + 1) % 4;
                mat[r][c] = 0;
            }
            int nr = r, nc = c;
            if (dir == 0) nc++;
            else if (dir == 1) nr++;
            else if (dir == 2) nc--;
            else nr--;
            if (nr < 0 || nr >= n || nc < 0 || nc >= m)
                return {r, c};
            r = nr;
            c = nc;
        }
    }
};
