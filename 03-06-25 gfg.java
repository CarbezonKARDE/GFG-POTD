import java.util.*;
class Solution {
    public int countSubstr(String s, int k) {
        return countAtMostKDistinct(s, k) - countAtMostKDistinct(s, k - 1);
    }
    private int countAtMostKDistinct(String s, int k) {
        int[] freq = new int[26];
        int left = 0, count = 0, distinct = 0;
        for (int right = 0; right < s.length(); right++) {
            if (freq[s.charAt(right) - 'a'] == 0) {
                distinct++;
            }
            freq[s.charAt(right) - 'a']++;

            while (distinct > k) {
                freq[s.charAt(left) - 'a']--;
                if (freq[s.charAt(left) - 'a'] == 0) {
                    distinct--;
                }
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }
}
