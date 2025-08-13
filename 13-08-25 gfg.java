import java.util.*;
class Solution {
    public int minSoldiers(int[] arr, int k) {
        int n = arr.length;
        int required = (n + 1) / 2;
        int luckyCount = 0;
        List<Integer> costs = new ArrayList<>();

        for (int soldiers : arr) {
            if (soldiers % k == 0) {
                luckyCount++;
            } else {
                costs.add(k - (soldiers % k));
            }
        }
        if (luckyCount >= required) return 0;
        Collections.sort(costs);
        int toMakeLucky = required - luckyCount;
        int totalAdded = 0;
        for (int i = 0; i < toMakeLucky; i++) {
            totalAdded += costs.get(i);
        }
        return totalAdded;
    }
}
