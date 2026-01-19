class Solution {
    public String removeKdig(String s, int k) {
        int n = s.length();
        if (k == n) return "0";
        StringBuilder stack = new StringBuilder();
        for (char ch : s.toCharArray()) {
            while (k > 0 && stack.length() > 0 && stack.charAt(stack.length() - 1) > ch) {
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }
            stack.append(ch);
        }
        while (k > 0 && stack.length() > 0) {
            stack.deleteCharAt(stack.length() - 1);
            k--;
        }
        int idx = 0;
        while (idx < stack.length() && stack.charAt(idx) == '0') {
            idx++;
        }
        String result = stack.substring(idx);
        return result.length() == 0 ? "0" : result;
    }
}
