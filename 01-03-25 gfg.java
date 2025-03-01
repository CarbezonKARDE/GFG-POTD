class Solution {
    static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentStr = new StringBuilder();
        int k = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                countStack.push(k);
                stringStack.push(currentStr);
                k = 0;
                currentStr = new StringBuilder();
            } else if (c == ']') {
                int repeatTimes = countStack.pop();
                StringBuilder decodedString = stringStack.pop();
                while (repeatTimes-- > 0) {
                    decodedString.append(currentStr);
                }
                currentStr = decodedString;
            } else {
                currentStr.append(c);
            }
        }
        return currentStr.toString();
    }
}
