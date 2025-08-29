import java.util.*;
class Solution {
    public static String smallestWindow(String s, String p) {
        if (s.length() < p.length()) return "";
        int[] targetFreq = new int[26];
        for (char c : p.toCharArray()) {
            targetFreq[c - 'a']++;
        }
        int[] windowFreq = new int[26];
        int required = p.length();
        int formed = 0;
        int left = 0, minLen = Integer.MAX_VALUE, start = -1;

        for (int right = 0; right < s.length(); right++) {
            char rc = s.charAt(right);
            windowFreq[rc - 'a']++;
            if (targetFreq[rc - 'a'] > 0 && windowFreq[rc - 'a'] <= targetFreq[rc - 'a']) {
                formed++;
            }
            while (formed == required) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
                char lc = s.charAt(left);
                windowFreq[lc - 'a']--;
                if (targetFreq[lc - 'a'] > 0 && windowFreq[lc - 'a'] < targetFreq[lc - 'a']) {
                    formed--;
                }
                left++;
            }
        }
        return start == -1 ? "" : s.substring(start, start + minLen);
    }
}
