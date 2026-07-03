class Solution {
    public int waysToIncreaseLCSBy1(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] pref = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    pref[i][j] = pref[i - 1][j - 1] + 1;
                else
                    pref[i][j] = Math.max(pref[i - 1][j], pref[i][j - 1]);
            }
        }
        int lcs = pref[n1][n2];
        int[][] suff = new int[n1 + 1][n2 + 1];
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j))
                    suff[i][j] = 1 + suff[i + 1][j + 1];
                else
                    suff[i][j] = Math.max(suff[i + 1][j], suff[i][j + 1]);
            }
        }
        int ans = 0;
        for (int pos = 0; pos <= n1; pos++) {
            boolean[] used = new boolean[26];
            for (int j = 0; j < n2; j++) {
                int ch = s2.charAt(j) - 'a';
                if (used[ch]) continue;
                if (pref[pos][j] + suff[pos][j + 1] == lcs) {
                    used[ch] = true;
                    ans++;
                }
            }
        }
        return ans;
    }
}
