import java.util.*;
class Solution {
    public static String caseSort(String s) {
        List<Character> upper = new ArrayList<>();
        List<Character> lower = new ArrayList<>();
        for (char ch : s.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                upper.add(ch);
            } else {
                lower.add(ch);
            }
        }
        Collections.sort(upper);
        Collections.sort(lower);
        StringBuilder result = new StringBuilder();
        int u = 0, l = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                result.append(upper.get(u++));
            } else {
                result.append(lower.get(l++));
            }
        }
        return result.toString();
    }
}
