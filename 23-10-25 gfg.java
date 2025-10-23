import java.util.*;
class Solution {
    public ArrayList<ArrayList<Integer>> kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            int dist = x * x + y * y;
            maxHeap.add(new int[]{dist, i});
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            int idx = maxHeap.poll()[1];
            ArrayList<Integer> point = new ArrayList<>();
            point.add(points[idx][0]);
            point.add(points[idx][1]);
            result.add(point);
        }
        return result;
    }
}
