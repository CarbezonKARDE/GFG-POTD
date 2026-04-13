class Solution {
    static int[] nextPalindrome(int[] num) {
        int n = num.length;
        boolean allNine = true;
        for (int x : num) {
            if (x != 9) {
                allNine = false;
                break;
            }
        }
        if (allNine) {
            int[] res = new int[n + 1];
            res[0] = 1;
            res[n] = 1;
            return res;
        }
        int[] ans = num.clone();
        for (int i = 0; i < n / 2; i++) {
            ans[n - i - 1] = ans[i];
        }
        boolean greater = false;
        for (int i = 0; i < n; i++) {
            if (ans[i] > num[i]) {
                greater = true;
                break;
            } else if (ans[i] < num[i]) {
                break;
            }
        }
        if (greater) return ans;
        int carry = 1;
        int mid = n / 2;
        if (n % 2 == 1) {
            ans[mid] += carry;
            carry = ans[mid] / 10;
            ans[mid] %= 10;
            mid--;
        } else {
            mid = mid - 1;
        }
        while (mid >= 0 && carry > 0) {
            ans[mid] += carry;
            carry = ans[mid] / 10;
            ans[mid] %= 10;
            mid--;
        }
        for (int i = 0; i < n / 2; i++) {
            ans[n - i - 1] = ans[i];
        }
        return ans;
    }
}
