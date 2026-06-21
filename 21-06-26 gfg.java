class Solution {
    public String chooseSwap(String s) {
        int n = s.length();
        boolean[] present = new boolean[26];
        for (char ch : s.toCharArray()) {
            present[ch - 'a'] = true;
        }
        char from = 0, to = 0;
        for (int i = 0; i < n; i++) {
            int curr = s.charAt(i) - 'a';
            for (int smaller = 0; smaller < curr; smaller++) {
                if (present[smaller]) {
                    from = s.charAt(i);
                    to = (char) ('a' + smaller);
                    StringBuilder ans = new StringBuilder();
                    for (char ch : s.toCharArray()) {
                        if (ch == from) {
                            ans.append(to);
                        } else if (ch == to) {
                            ans.append(from);
                        } else {
                            ans.append(ch);
                        }
                    }
                    return ans.toString();
                }
            }
            present[curr] = false;
        }
        return s;
    }
}
