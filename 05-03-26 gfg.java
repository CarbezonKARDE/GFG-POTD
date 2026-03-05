class Solution {
    public int longestKSubstr(String s, int k) {
        int[] freq = new int[26];
        int left = 0, maxLen = -1, distinct = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (freq[c - 'a'] == 0) distinct++;
            freq[c - 'a']++;
            while (distinct > k) {
                char l = s.charAt(left);
                freq[l - 'a']--;

                if (freq[l - 'a'] == 0) distinct--;
                left++;
            }
            if (distinct == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
        return maxLen;
    }
}
