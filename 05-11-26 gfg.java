class Solution {
    public int getMinimumDays(String s, int[] p) {
        int n = s.length();
        boolean valid = true;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                valid = false;
                break;
            }
        }
        if (valid) return 0;
        int[] day = new int[n];
        for (int i = 0; i < n; i++) {
            day[p[i]] = i + 1;
        }
        int low = 1, high = n;
        int ans = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            boolean possible = true;
            for (int i = 0; i < n - 1; i++) {
                if (day[i] > mid &&
                    day[i + 1] > mid &&
                    s.charAt(i) == s.charAt(i + 1)) {

                    possible = false;
                    break;
                }
            }
            if (possible) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
