class Solution {
    public ArrayList<Integer> optimalArray(int[] arr) {
        int n = arr.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }
        ArrayList<Integer> ans = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int m = i / 2;
            long median = arr[m];
            long leftCost = median * (m + 1L) - prefix[m + 1];
            long rightCost =
                    (prefix[i + 1] - prefix[m + 1])
                    - median * (i - m);
            ans.add((int) (leftCost + rightCost));
        }
        return ans;
    }
}
