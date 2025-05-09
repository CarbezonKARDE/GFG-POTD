class Solution {
    public String findMaximumNum(String str, int k) {
        StringBuilder maxStr = new StringBuilder(str);
        findMaxUtil(new StringBuilder(str), k, maxStr, 0);
        return maxStr.toString();
    }
    private void findMaxUtil(StringBuilder str, int k, StringBuilder maxStr, int index) {
        if (k == 0 || index >= str.length()) return;
        int n = str.length();
        char maxChar = str.charAt(index);
        for (int i = index + 1; i < n; i++) {
            if (str.charAt(i) > maxChar)
                maxChar = str.charAt(i);
        }
        if (maxChar != str.charAt(index))
            k--;
        for (int i = n - 1; i >= index; i--) {
            if (str.charAt(i) == maxChar) {
                swap(str, index, i);
                if (str.toString().compareTo(maxStr.toString()) > 0) {
                    maxStr.setLength(0);
                    maxStr.append(str);
                }
                findMaxUtil(str, k, maxStr, index + 1);
                swap(str, index, i);
            }
        }
    }
    private void swap(StringBuilder sb, int i, int j) {
        char temp = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, temp);
    }
}
