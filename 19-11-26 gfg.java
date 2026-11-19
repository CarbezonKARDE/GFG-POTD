import java.util.Arrays;
class Solution {
    public void sortIt(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int[] result = new int[n];
        int index = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] % 2 != 0) {
                result[index++] = arr[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0) {
                result[index++] = arr[i];
            }
        }
        for (int i = 0; i < n; i++) {
            arr[i] = result[i];
        }
    }
}
