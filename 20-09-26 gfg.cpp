class Solution {
public:
    int largestSubsquare(vector<vector<char>> &mat) {
        int n = mat.size();
        vector<vector<int>> right(n, vector<int>(n, 0));
        vector<vector<int>> down(n, vector<int>(n, 0));
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (mat[i][j] == 'X') {
                    right[i][j] = 1 + (j + 1 < n ? right[i][j + 1] : 0);
                    down[i][j] = 1 + (i + 1 < n ? down[i + 1][j] : 0);
                }
            }
        }
        for (int size = n; size >= 1; size--) {
            for (int i = 0; i + size <= n; i++) {
                for (int j = 0; j + size <= n; j++) {
                    if (right[i][j] < size || down[i][j] < size)
                        continue;
                    if (right[i + size - 1][j] >= size &&
                        down[i][j + size - 1] >= size) {
                        return size;
                    }
                }
            }
        }
        return 0;
    }
};
