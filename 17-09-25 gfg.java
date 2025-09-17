class Solution {
    static String decodeString(String s) {
        StringBuilder currStr = new StringBuilder();
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        int num = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if (ch == '[') {
                countStack.push(num);
                strStack.push(currStr);
                num = 0;
                currStr = new StringBuilder();
            } else if (ch == ']') {
                int repeat = countStack.pop();
                StringBuilder decoded = strStack.pop();
                for (int i = 0; i < repeat; i++) {
                    decoded.append(currStr);
                }
                currStr = decoded;
            } else {
                currStr.append(ch);
            }
        }
        return currStr.toString();
    }
}
