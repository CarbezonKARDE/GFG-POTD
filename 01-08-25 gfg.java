import java.util.*;
class Solution {
    public int countBalanced(String[] arr) {
        Set<Character> vowelsSet = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u')
        );
        Map<Integer, Integer> freqMap = new HashMap<>();
        freqMap.put(0, 1);
        int diff = 0;
        int result = 0;
        for (String str : arr) {
            for (char ch : str.toCharArray()) {
                if (vowelsSet.contains(ch)) {
                    diff += 1;
                } else {
                    diff -= 1;
                }
            }
            result += freqMap.getOrDefault(diff, 0);
            freqMap.put(diff, freqMap.getOrDefault(diff, 0) + 1);
        }
        return result;
    }
}
