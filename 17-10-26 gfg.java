class Solution {
    public boolean isItPossible(String s1, String s2) {
        int n = s1.length();
        if (n != s2.length()) {
            return false;
        }
        int i = 0, j = 0;
        while (i < n && j < n) {
            while (i < n && s1.charAt(i) == '#') {
                i++;
            }
            while (j < n && s2.charAt(j) == '#') {
                j++;
            }
            if (i == n || j == n) {
                return i == n && j == n;
            }
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(j);
            if (c1 != c2) {
                return false;
            }
            if (c1 == 'A' && i < j) {
                return false;
            }
            if (c1 == 'B' && i > j) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
}
