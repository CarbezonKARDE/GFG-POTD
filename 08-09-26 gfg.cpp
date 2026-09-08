class Solution {
public:
    vector<vector<int>> searchWord(vector<vector<char>> &mat, string &word) {
        int n = mat.size();
        int m = mat[0].size();
        vector<vector<int>> ans;
        int dr[] = {-1, -1, -1, 0, 0, 1, 1, 1};
        int dc[] = {-1, 0, 1, -1, 1, -1, 0, 1};
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (mat[r][c] != word[0])
                    continue;
                for (int d = 0; d < 8; d++) {
                    int nr = r;
                    int nc = c;
                    int k;
                    for (k = 1; k < word.size(); k++) {
                        nr += dr[d];
                        nc += dc[d];
                        if (nr < 0 || nr >= n || nc < 0 || nc >= m ||
                            mat[nr][nc] != word[k]) {
                            break;
                        }
                    }
                    if (k == word.size()) {
                        ans.push_back({r, c});
                        break;
                    }
                }
            }
        }
        return ans;
    }
};
