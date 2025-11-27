class Solution {
    int subsetXORSum(int arr[]) {
        int OR = 0;
        int n = arr.length;
        for (int x : arr) {
            OR |= x;
        }
        return OR * (1 << (n - 1));
    }
}
