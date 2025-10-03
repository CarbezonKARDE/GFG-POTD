import java.util.*;
class Solution {
    private static final String[] KEYPAD = {
        "",
        "",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz"
    };
    public ArrayList<String> possibleWords(int[] arr) {
        ArrayList<String> result = new ArrayList<>();
        if (arr == null || arr.length == 0) return result;
        Queue<String> queue = new LinkedList<>();
        queue.add("");
        for (int digit : arr) {
            String letters = KEYPAD[digit];
            if (letters.isEmpty()) continue;

            int size = queue.size();
            while (size-- > 0) {
                String prefix = queue.poll();
                for (char c : letters.toCharArray()) {
                    queue.add(prefix + c);
                }
            }
        }
        result.addAll(queue);
        return result;
    }
}
