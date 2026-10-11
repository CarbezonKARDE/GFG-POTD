class Solution {
    public void mergeTwoParts(int[] arr) {
        int n = arr.length;
        int breakPoint = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1]) {
                breakPoint = i;
                break;
            }
        }
        if (breakPoint == 0) {
            return;
        }
        int[] temp = new int[n];
        int i = 0, j = breakPoint, k = 0;
        while (i < breakPoint && j < n) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i < breakPoint) {
            temp[k++] = arr[i++];
        }
        while (j < n) {
            temp[k++] = arr[j++];
        }
        System.arraycopy(temp, 0, arr, 0, n);
    }
}
