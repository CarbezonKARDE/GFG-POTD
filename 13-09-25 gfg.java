import java.util.*;
class Solution {
    public static int minCost(int n, int m, int[] x, int[] y) {
        Arrays.sort(x);
        Arrays.sort(y);
        int i = x.length - 1;
        int j = y.length - 1;
        int horizontalSegments = 1, verticalSegments = 1;
        int totalCost = 0;
        while (i >= 0 && j >= 0) {
            if (x[i] > y[j]) {
                totalCost += x[i] * horizontalSegments;
                verticalSegments++;
                i--;
            } else {
                totalCost += y[j] * verticalSegments;
                horizontalSegments++;
                j--;
            }
        }
        while (i >= 0) {
            totalCost += x[i] * horizontalSegments;
            verticalSegments++;
            i--;
        }
        while (j >= 0) {
            totalCost += y[j] * verticalSegments;
            horizontalSegments++;
            j--;
        }
        return totalCost;
    }
}
