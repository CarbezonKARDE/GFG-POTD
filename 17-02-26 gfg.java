import java.util.*;
class Solution {
    public static int overlapInt(int[][] arr) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] interval : arr) {
            int start = interval[0];
            int end = interval[1];
            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end + 1, map.getOrDefault(end + 1, 0) - 1);
        }
        int curr = 0;
        int maxOverlap = 0;
        for (int val : map.values()) {
            curr += val;
            maxOverlap = Math.max(maxOverlap, curr);
        }
        return maxOverlap;
    }
}
