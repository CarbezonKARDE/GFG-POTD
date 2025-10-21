import java.util.*;
class Solution {
    public ArrayList<Integer> topKFreq(int[] arr, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (b[1] == a[1]) return b[0] - a[0];
                return b[1] - a[1];
            }
        );
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            pq.add(new int[]{e.getKey(), e.getValue()});
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            result.add(pq.poll()[0]);
        }
        return result;
    }
}
