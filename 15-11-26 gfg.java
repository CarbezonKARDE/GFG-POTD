class Solution {
    public int subsequenceSum(String s) {
        long MOD = 1000000007L;
        long sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i) - '0';
        }
        long power = 1;
        int n = s.length();
        for (int i = 1; i < n; i++) {
            power = (power * 2) % MOD;
        }
        return (int)((sum * power) % MOD);
    }
}
