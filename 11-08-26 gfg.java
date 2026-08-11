class Solution {
    ArrayList<Integer> largestSquare(int[][] mat, int[][] queries, int k) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] pref = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                pref[i + 1][j + 1] =
                    mat[i][j]
                    + pref[i][j + 1]
                    + pref[i + 1][j]
                    - pref[i][j];
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int[] q : queries) {
            int r = q[0];
            int c = q[1];
            int maxRadius = Math.min(
                Math.min(r, n - 1 - r),
                Math.min(c, m - 1 - c)
            );
            if (getSum(pref, r, c, r, c) > k) {
                ans.add(-1);
                continue;
            }
            int low = 0;
            int high = maxRadius;
            int best = 0;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                int top = r - mid;
                int bottom = r + mid;
                int left = c - mid;
                int right = c + mid;
                int ones = getSum(pref, top, left, bottom, right);
                if (ones <= k) {
                    best = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            ans.add(2 * best + 1);
        }
        return ans;
    }
    private int getSum(int[][] pref, int r1, int c1, int r2, int c2) {
        return pref[r2 + 1][c2 + 1]
             - pref[r1][c2 + 1]
             - pref[r2 + 1][c1]
             + pref[r1][c1];
    }
}
