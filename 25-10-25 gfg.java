import java.util.*;
class Solution {
    public int minOperations(int[] arr) {
        double sum = 0;
        for (int num : arr) sum += num;
        double target = sum / 2.0;
        int operations = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : arr) pq.add((double) num);
        double currentSum = sum;
        while (currentSum > target) {
            double largest = pq.poll();
            double half = largest / 2.0;
            currentSum -= half;
            pq.add(half);
            operations++;
        }
        return operations;
    }
}
