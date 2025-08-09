class Solution {
    int getLongestPrefix(String s) {
        int n = s.length();
        if (n <= 1) return -1;
        int[] Z = computeZ(s);
        for (int L = n - 1; L >= 1; L--) {
            if (Z[L] >= n - L) return L;
        }
        return -1;
    }
    private int[] computeZ(String s) {
        int n = s.length();
        int[] Z = new int[n];
        int l = 0, r = 0;
        for (int i = 1; i < n; i++) {
            if (i <= r) {
                Z[i] = Math.min(r - i + 1, Z[i - l]);
            }
            while (i + Z[i] < n && s.charAt(Z[i]) == s.charAt(i + Z[i])) {
                Z[i]++;
            }
            if (i + Z[i] - 1 > r) {
                l = i;
                r = i + Z[i] - 1;
            }
        }
        return Z;
    }
}
