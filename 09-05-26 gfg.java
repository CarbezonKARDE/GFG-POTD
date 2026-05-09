class Solution {
    public int countSpanTree(int n, int[][] edges) {
        if (n == 1) return 1;
        long[][] lap = new long[n][n];
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            lap[u][u]++;
            lap[v][v]++;
            lap[u][v]--;
            lap[v][u]--;
        }
        long[][] mat = new long[n - 1][n - 1];

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                mat[i][j] = lap[i][j];
            }
        }
        return (int)Math.round(determinant(mat, n - 1));
    }
    private double determinant(long[][] a, int n) {
        double[][] mat = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = a[i][j];
            }
        }
        double det = 1;
        for (int i = 0; i < n; i++) {
            int pivot = i;
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(mat[j][i]) > Math.abs(mat[pivot][i])) {
                    pivot = j;
                }
            }
            if (Math.abs(mat[pivot][i]) < 1e-9) {
                return 0;
            }
            if (pivot != i) {
                double[] temp = mat[i];
                mat[i] = mat[pivot];
                mat[pivot] = temp;
                det *= -1;
            }
            det *= mat[i][i];
            for (int j = i + 1; j < n; j++) {
                double factor = mat[j][i] / mat[i][i];
                for (int k = i; k < n; k++) {
                    mat[j][k] -= factor * mat[i][k];
                }
            }
        }
        return det;
    }
}
