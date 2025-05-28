class Solution {
  public:
    bool ValidCorner(vector<vector<int> >& mat) {
        int n = mat.size();
        if (n == 0) return false;
        int m = mat[0].size();
        for (int c1 = 0; c1 < m; ++c1) {
            for (int c2 = c1 + 1; c2 < m; ++c2) {
                int count = 0;
                for (int r = 0; r < n; ++r) {
                    if (mat[r][c1] == 1 && mat[r][c2] == 1) {
                        count++;
                        if (count >= 2) return true;
                    }
                }
            }
        }
        return false;
    }
};
