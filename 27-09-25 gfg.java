class Solution {
    public int kBitFlips(int[] arr, int k) {
        int n = arr.length;
        int flips = 0;
        int currFlips = 0;
        int[] isFlipped = new int[n];
        for (int i = 0; i < n; i++) {
            if (i >= k) {
                currFlips ^= isFlipped[i - k];
            }
            if ((arr[i] ^ currFlips) == 0) {
                if (i + k > n) return -1;
                flips++;
                currFlips ^= 1;
                isFlipped[i] = 1;
            }
        }
        return flips;
    }
}
