class Solution {
    public String multiplyStrings(String s1, String s2) {
        boolean isNegative = false;
        if (s1.length() > 0 && s1.charAt(0) == '-') {
            isNegative = !isNegative;
            s1 = s1.substring(1);
        }
        if (s2.length() > 0 && s2.charAt(0) == '-') {
            isNegative = !isNegative;
            s2 = s2.substring(1);
        }
        s1 = removeLeadingZeros(s1);
        s2 = removeLeadingZeros(s2);
        if (s1.equals("0") || s2.equals("0")) {
            return "0";
        }
        int m = s1.length(), n = s2.length();
        int[] result = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            int d1 = s1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int d2 = s2.charAt(j) - '0';
                int sum = d1 * d2 + result[i + j + 1];
                result[i + j + 1] = sum % 10;
                result[i + j] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < result.length && result[i] == 0) i++;
        for (; i < result.length; i++) {
            sb.append(result[i]);
        }
        if (isNegative) {
            sb.insert(0, '-');
        }
        return sb.toString();
    }
    private String removeLeadingZeros(String str) {
        int i = 0;
        while (i < str.length() && str.charAt(i) == '0') i++;
        return i == str.length() ? "0" : str.substring(i);
    }
}
