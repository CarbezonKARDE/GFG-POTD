class Solution {
    public int maxSum(String s) {
        int n = s.length();
        if (n <= 1) return 0;
        int[] d1 = manacherOdd(s);
        int[] bestRight = computeBestRightFromD1(d1, n);
        String rs = new StringBuilder(s).reverse().toString();
        int[] d1r = manacherOdd(rs);
        int[] bestRightRev = computeBestRightFromD1(d1r, n);
        int[] bestLeft = new int[n];
        for (int i = 0; i < n; i++) bestLeft[i] = bestRightRev[n - 1 - i];
        int[] prefix = new int[n];
        int cur = 0;
        for (int i = 0; i < n; i++) {
            cur = Math.max(cur, bestRight[i]);
            prefix[i] = cur;
        }
        int[] suffix = new int[n];
        cur = 0;
        for (int i = n - 1; i >= 0; i--) {
            cur = Math.max(cur, bestLeft[i]);
            suffix[i] = cur;
        }

        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            ans = Math.max(ans, prefix[i] + suffix[i + 1]);
        }
        return ans;
    }
    private int[] manacherOdd(String s) {
        int n = s.length();
        int[] d1 = new int[n];
        int l = 0, r = -1;
        for (int i = 0; i < n; i++) {
            int k = (i > r) ? 1 : Math.min(d1[l + r - i], r - i + 1);
            while (i - k >= 0 && i + k < n && s.charAt(i - k) == s.charAt(i + k)) k++;
            d1[i] = k;
            if (i + k - 1 > r) {
                l = i - k + 1;
                r = i + k - 1;
            }
        }
        return d1;
    }
    private int[] computeBestRightFromD1(int[] d1, int n) {
        int[] bestRight = new int[n];
        int[] rightEnd = new int[n];
        for (int i = 0; i < n; i++) rightEnd[i] = i + d1[i] - 1;
        java.util.ArrayDeque<Integer> dq = new java.util.ArrayDeque<>();
        for (int r = 0; r < n; r++) {
            dq.addLast(r);
            while (!dq.isEmpty() && rightEnd[dq.peekFirst()] < r) dq.pollFirst();
            if (!dq.isEmpty()) {
                int minCenter = dq.peekFirst();
                bestRight[r] = 2 * (r - minCenter) + 1;
            } else {
                bestRight[r] = 0;
            }
        }
        return bestRight;
    }
}
