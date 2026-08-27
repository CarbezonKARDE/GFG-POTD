import java.util.*;
class Solution {
    public int maxArea(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    mat[i][j] += mat[i - 1][j];
                }
            }
        }
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int[] heights = mat[i].clone();
            Arrays.sort(heights);
            for (int j = m - 1, width = 1; j >= 0; j--, width++) {
                maxArea = Math.max(maxArea, heights[j] * width);
            }
        }
        return maxArea;
    }
}
