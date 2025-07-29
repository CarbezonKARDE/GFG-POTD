import java.util.*;
class Solution {
    public ArrayList<Integer> asciirange(String s) {
        Map<Character, Integer> firstIndex = new HashMap<>();
        Map<Character, Integer> lastIndex = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            firstIndex.putIfAbsent(ch, i);
            lastIndex.put(ch, i);
        }
        for (char ch : firstIndex.keySet()) {
            int start = firstIndex.get(ch);
            int end = lastIndex.get(ch);
            if (start < end) {
                int sum = 0;
                for (int i = start + 1; i < end; i++) {
                    sum += s.charAt(i);
                }
                if (sum > 0) {
                    result.add(sum);
                }
            }
        }
        return result;
    }
}
