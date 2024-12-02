class Solution {
    public static int minChar(String s) {
        int N = s.length();
        String reversedStr = new StringBuilder(s).reverse().toString();
        String modifiedStr = s + "$" + reversedStr;
        int[] lps = new int[2 * N + 1];
        computeLPSArray(modifiedStr, lps);
        return N - lps[2 * N];
    }
    private static void computeLPSArray(String str, int[] lps) {
        int N = str.length();
        int len = 0;  
        
        int i = 1;
        while (i < N) {
            if (str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
}
