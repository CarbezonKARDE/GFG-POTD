import java.util.ArrayList;
class Solution {
    public ArrayList<Integer> constructArr(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        int len = arr.length;
        int n = 0;
        for (int i = 1; i * (i - 1) / 2 <= len; i++) {
            if (i * (i - 1) / 2 == len) {
                n = i;
                break;
            }
        }
        if (n == 0) return res;
        if (n == 2) {
            long total = arr[0];
            res.add((int)1);
            res.add((int)(total - 1));
            return res;
        }
        long a = arr[0];
        long b = arr[1];
        long c = arr[n - 1];
        long res0 = (a + b - c) / 2;
        res.add((int)res0);
        res.add((int)(a - res0));
        res.add((int)(b - res0));
        int arrIndex = 2;
        for (int i = 3; i < n; i++) {
            long value = arr[i - 1];
            res.add((int)(value - res0));
        }
        return res;
    }
}
