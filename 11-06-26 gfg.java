class Solution {
    public int findIndex(String s) {
        int n = s.length();
        int totalClose = 0;
        for (char ch : s.toCharArray()) {
            if (ch == ')') totalClose++;
        }
        int openBefore = 0;
        int closeBefore = 0;
        for (int k = 0; k <= n; k++) {
            int closeFromK = totalClose - closeBefore;
            if (openBefore == closeFromK) {
                return k;
            }
            if (k < n) {
                if (s.charAt(k) == '(') {
                    openBefore++;
                } else {
                    closeBefore++;
                }
            }
        }
        return -1;
    }
}
