class Solution {
    private int[] catalan(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = 0;
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp;
    }
    public ArrayList<Integer> countBSTs(int[] arr) {
        int n = arr.length;
        int[] cat = catalan(n);
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int left = 0, right = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] < arr[i]) left++;
                else if (arr[j] > arr[i]) right++;
            }
            result.add(cat[left] * cat[right]);
        }
        return result;
    }
}
