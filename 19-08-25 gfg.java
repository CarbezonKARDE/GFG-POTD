import java.util.*;
class Solution {
    public ArrayList<Integer> farMin(int[] arr) {
        int n = arr.length;
        int[] suffixMin = new int[n];
        suffixMin[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(arr[i], suffixMin[i + 1]);
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int l = i + 1, r = n - 1, ans = -1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (suffixMin[mid] < arr[i]) {
                    ans = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            res.add(ans);
        }
        return res;
    }
}
