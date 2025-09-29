import java.util.*;
class Solution {
    public int maxSubarrSum(int[] arr, int a, int b) {
        int n = arr.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }
        Deque<Integer> dq = new ArrayDeque<>();
        int ans = Integer.MIN_VALUE;
        for (int r = a; r <= n; r++) {
            int idx = r - a;
            while (!dq.isEmpty() && prefix[dq.peekLast()] >= prefix[idx]) {
                dq.pollLast();
            }
            dq.addLast(idx);
            while (!dq.isEmpty() && dq.peekFirst() < r - b) {
                dq.pollFirst();
            }
            if (!dq.isEmpty()) {
                ans = Math.max(ans, (int)(prefix[r] - prefix[dq.peekFirst()]));
            }
        }
        return ans;
    }
}
