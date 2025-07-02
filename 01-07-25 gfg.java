import java.util.*;

class Solution {
    public int substrCount(String s, int k) {
        if (s.length() < k) return 0;
        
        int count = 0;
        Map<Character, Integer> freq = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            
            if (i >= k) {
                char outChar = s.charAt(i - k);
                freq.put(outChar, freq.get(outChar) - 1);
                if (freq.get(outChar) == 0) {
                    freq.remove(outChar);
                }
            }

            if (i >= k - 1) {
                if (freq.size() == k - 1) {
                    count++;
                }
            }
        }

        return count;
    }
}
