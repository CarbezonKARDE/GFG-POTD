class Solution {
    StringBuilder addCarry(StringBuilder str) {
        int carry = 1;
        boolean isBreak = false;
        for(int i = str.length() - 1; i >= 0; --i) {
            if(str.charAt(i) == '9') 
                str.setCharAt(i,'0');
            else {
                int num = Integer.parseInt(str.charAt(i) + "");
                ++num;
                str.setCharAt(i,(char)(num + '0'));
                isBreak = true;
                break;
            }
        }
        if(!isBreak) str.insert(0,"1");
        return str;
    }
    String roundToNearest(String str) {
        StringBuilder sb = new StringBuilder(str);
        int n = str.length();
        int num = Integer.parseInt(sb.charAt(n-1) + "");
        sb.deleteCharAt(n-1);
        int mod = num % 10;
        if(mod <= 5) {
            num = 0;
        } else {
             num = 0;
             sb = addCarry(sb);
        }
        sb.append(String.valueOf(num));
        return sb.toString();
    }
}
