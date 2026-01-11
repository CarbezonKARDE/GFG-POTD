class Solution {
    public String minWindow(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int minLen = Integer.MAX_VALUE;
        int startIndex = -1;
        int i = 0;
        while (i < n1) {
            int j = 0;
            while (i < n1 && j < n2) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    j++;
                }
                i++;
            }
            if (j < n2) break;
            int end = i - 1;
            j = n2 - 1;
            while (j >= 0) {
                if (s1.charAt(i - 1) == s2.charAt(j)) {
                    j--;
                }
                i--;
            }
            int start = i;
            int length = end - start + 1;
            if (length < minLen) {
                minLen = length;
                startIndex = start;
            }
            i = start + 1;
        }
        return (startIndex == -1) ? "" : s1.substring(startIndex, startIndex + minLen);
    }
}
