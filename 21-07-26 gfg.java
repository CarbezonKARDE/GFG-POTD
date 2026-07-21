class Solution {
    public int maxIndexDifference(String s) {
        int n = s.length();
        int[] maxEnd = new int[26];
        for (int i = 0; i < 26; i++) {
            maxEnd[i] = -1;
        }
        int ans = -1;
        for (int i = n - 1; i >= 0; i--) {
            int ch = s.charAt(i) - 'a';
            int reach = i;
            if (ch < 25 && maxEnd[ch + 1] != -1) {
                reach = maxEnd[ch + 1];
            }
            if (ch == 0) {
                ans = Math.max(ans, reach - i);
            }
            maxEnd[ch] = Math.max(maxEnd[ch], reach);
        }
        return ans;
    }
}
