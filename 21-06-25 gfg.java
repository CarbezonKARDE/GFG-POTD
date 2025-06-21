import java.util.*;
class Solution {
    public int catchThieves(char[] arr, int k) {
        int n = arr.length;
        Queue<Integer> police = new LinkedList<>();
        Queue<Integer> thief = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'P') {
                police.add(i);
            } else if (arr[i] == 'T') {
                thief.add(i);
            }
            while (!police.isEmpty() && !thief.isEmpty()) {
                int p = police.peek();
                int t = thief.peek();
                if (Math.abs(p - t) <= k) {
                    count++;
                    police.poll();
                    thief.poll();
                } else if (t < p) {
                    thief.poll();
                } else {
                    police.poll();
                }
            }
        }
        return count;
    }
}
