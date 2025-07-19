import java.util.*;
class Solution {
    public int vowelCount(String s) {
        Set<Character> vowelSet = Set.of('a', 'e', 'i', 'o', 'u');
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (vowelSet.contains(c)) {
                freq.put(c, freq.getOrDefault(c, 0) + 1);
            }
        }
        int distinctVowels = freq.size();
        if (distinctVowels == 0) return 0;
        int totalSelections = 1;
        for (int count : freq.values()) {
            totalSelections *= count;
        }
        int permutations = factorial(distinctVowels);
        return totalSelections * permutations;
    }
    private int factorial(int n) {
        int res = 1;
        for (int i = 2; i <= n; i++) res *= i;
        return res;
    }
}
