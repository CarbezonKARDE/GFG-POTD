class Solution {
    public String addBinary(String s1, String s2) {
        String first = s1.length() >= s2.length() ? s1 : s2;
        String second = s1.length() < s2.length() ? s1 : s2;
        String ans = add(first, second);
        return ans;
    }
    public String add(String f, String s) {
        StringBuilder sb = new StringBuilder();
        int i = f.length()-1;
        int j = s.length()-1;
        int carry = 0;
        int rem = 0;
        int n = f.length(), m = s.length();
        while(i>=0 && j>=0) {
            int a = f.charAt(i) - '0';
            int b = s.charAt(j) - '0';
            rem = (a+b+carry)%2;
            carry = (a+b+carry)/2;
            sb.append(rem);
            i--;
            j--;
        }
        while(i>=0) {
            int a = f.charAt(i) - '0';
            rem = (carry+a)%2;
            carry = (carry+a)/2;
            sb.append(rem);
            i--;
        }
        if(carry!=0) sb.append(carry);
        int k = sb.length()-1;
        while(k>=0 && sb.charAt(k)=='0') {
            sb.deleteCharAt(k);
            k--;
        }
        sb.reverse();
        return sb.toString();
    }
}
