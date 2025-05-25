import java.util.*;
class Solution {
    boolean pythagoreanTriplet(int[] arr) {
        int n = arr.length;
        Set<Integer> squares = new HashSet<>();
        for (int i = 0; i < n; i++) {
            squares.add(arr[i] * arr[i]);
        }
        for (int i = 0; i < n; i++) {
            int a = arr[i];
            for (int j = i + 1; j < n; j++) {
                int b = arr[j];
                int sum = a * a + b * b;
                if (squares.contains(sum)) {
                    return true;
                }
            }
        }

        return false;
    }
}
