import java.util.*;
class Solution {
    public int powerfulInteger(int[][] intervals, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] interval : intervals) {
            map.put(interval[0], map.getOrDefault(interval[0], 0) + 1);
            map.put(interval[1] + 1, map.getOrDefault(interval[1] + 1, 0) - 1);
        }
        int active = 0;
        int maxPowerful = -1;
        Integer prev = null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int point = entry.getKey();
            int delta = entry.getValue();
            if (prev != null && active >= k) {
                maxPowerful = Math.max(maxPowerful, point - 1);
            }
            active += delta;
            prev = point;
        }
        return maxPowerful;
    }
}
