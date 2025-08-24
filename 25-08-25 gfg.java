import java.util.*;
class Solution {
    public int maximizeMedian(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        if (n % 2 == 1) {
            return (int) maximizeOdd(arr, k);
        } else {
            long sumTwo = maximizeEvenSumTwo(arr, k);
            return (int) (sumTwo / 2);
        }
    }
    private long maximizeOdd(int[] arr, long k) {
        int n = arr.length;
        int start = n / 2;
        int m = n - start;
        long[] B = new long[m];
        for (int i = 0; i < m; ++i) B[i] = arr[start + i];

        long curr = B[0];
        long count = 1;
        for (int i = 1; i < m; ++i) {
            long diff = B[i] - curr;
            long cost = diff * count;
            if (cost <= k) {
                k -= cost;
                curr = B[i];
                count++;
            } else {
                curr += k / count;
                k = 0;
                break;
            }
        }
        if (k > 0) curr += k / count;
        return curr;
    }
    private long maximizeEvenSumTwo(int[] arr, long k) {
        int n = arr.length;
        int L = n / 2 - 1;
        int m = n - L;
        long[] B = new long[m];
        for (int i = 0; i < m; ++i) B[i] = arr[L + i];
        long curr = B[0];
        int i = 0;
        long count = 1;
        while (i + 1 < m) {
            long next = B[i + 1];
            long diff = next - curr;
            long cost = diff * count;
            if (cost <= k) {
                k -= cost;
                curr = next;
                i++;
                count++;
            } else {
                long add = k / count;
                long rem = k % count;
                long base = curr + add;
                if (count == 1) {
                    return base + B[1];
                } else {
                    long c = count;
                    if (c - rem >= 2) return 2 * base;
                    else if (c - rem == 1) return 2 * base + 1;
                    else return 2 * (base + 1);
                }
            }
        }
        long add = k / count;
        long rem = k % count;
        long base = curr + add;
        if (count == 1) {
            return base + (m > 1 ? B[1] : base);
        } else {
            long c = count;
            if (c - rem >= 2) return 2 * base;
            else if (c - rem == 1) return 2 * base + 1;
            else return 2 * (base + 1);
        }
    }
}
