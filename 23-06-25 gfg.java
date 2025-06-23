import java.util.*;
class Solution {
    String minSum(int[] arr) {
        Arrays.sort(arr);
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                num1.append(arr[i]);
            } else {
                num2.append(arr[i]);
            }
        }
        String sum = addStrings(num1.toString(), num2.toString());
        return stripLeadingZeros(sum);
    }
    private String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int carry = 0, i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = (i >= 0) ? num1.charAt(i--) - '0' : 0;
            int digit2 = (j >= 0) ? num2.charAt(j--) - '0' : 0;

            int sum = digit1 + digit2 + carry;
            res.append(sum % 10);
            carry = sum / 10;
        }
        return res.reverse().toString();
    }
    private String stripLeadingZeros(String str) {
        int i = 0;
        while (i < str.length() && str.charAt(i) == '0') i++;
        return (i == str.length()) ? "0" : str.substring(i);
    }
}
