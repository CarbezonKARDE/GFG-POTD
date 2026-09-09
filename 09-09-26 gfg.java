class Solution {
    public int findMax(int n) {
        String s = String.valueOf(n);
        int best = n;
        int maxSum = digitSum(n);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') continue;
            String candidate = s.substring(0, i)
                    + (char)(s.charAt(i) - 1)
                    + "9".repeat(s.length() - i - 1);
            int num = Integer.parseInt(candidate);
            int sum = digitSum(num);
            if (sum > maxSum || (sum == maxSum && num > best)) {
                maxSum = sum;
                best = num;
            }
        }
        return best;
    }
    private int digitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
