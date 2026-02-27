class Solution {
    public int countSquare(int[][] mat, int x) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] pref = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                pref[i][j] = mat[i - 1][j - 1] 
                           + pref[i - 1][j] 
                           + pref[i][j - 1] 
                           - pref[i - 1][j - 1];
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int maxSize = Math.min(n - i, m - j);
                for (int size = 1; size <= maxSize; size++) {
                    int r1 = i;
                    int c1 = j;
                    int r2 = i + size - 1;
                    int c2 = j + size - 1;
                    int sum = pref[r2 + 1][c2 + 1]
                            - pref[r1][c2 + 1]
                            - pref[r2 + 1][c1]
                            + pref[r1][c1];
                    
                    if (sum == x) count++;
                }
            }
        }
        return count;
    }
}
