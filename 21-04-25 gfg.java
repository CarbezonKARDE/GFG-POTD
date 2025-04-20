class Solution {
    static int missingNum(int[] arr) {
        int n = arr.length;
        int xor = 0;
        for (int i = 0;i < n;i++){
            xor ^= (i+1) ^ arr[i];
        }
        return xor ^ (n+1);
    }
}
