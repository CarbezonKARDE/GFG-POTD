class Solution {
    public static ArrayList<Integer> increasingNumbers(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (n == 1) {
            for (int i = 0; i <= 9; i++) {
                ans.add(i);
            }
            return ans;
        }
        if (n > 9) return ans;
        generate(1, n, 0, ans);
        return ans;
    }
    static void generate(int start, int len, int num, ArrayList<Integer> ans) {
        if (len == 0) {
            ans.add(num);
            return;
        }
        for (int d = start; d <= 9; d++) {
            generate(d + 1, len - 1, num * 10 + d, ans);
        }
    }
}
