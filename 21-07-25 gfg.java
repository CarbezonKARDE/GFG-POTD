import java.util.*;
class Solution {
    static final int MAX = 10001;
    public int cntCoprime(int[] arr) {
        int[] freq = new int[MAX];
        int n = arr.length;
        for (int num : arr) {
            freq[num]++;
        }
        int[] cnt = new int[MAX];
        for (int d = 1; d < MAX; d++) {
            for (int multiple = d; multiple < MAX; multiple += d) {
                cnt[d] += freq[multiple];
            }
        }
        long[] notCoprime = new long[MAX];
        for (int d = MAX - 1; d >= 2; d--) {
            long c = cnt[d];
            notCoprime[d] = (c * (c - 1)) / 2;
            for (int mult = 2 * d; mult < MAX; mult += d) {
                notCoprime[d] -= notCoprime[mult];
            }
        }
        long totalPairs = ((long) n * (n - 1)) / 2;
        for (int d = 2; d < MAX; d++) {
            totalPairs -= notCoprime[d];
        }
        return (int) totalPairs;
    }
}
