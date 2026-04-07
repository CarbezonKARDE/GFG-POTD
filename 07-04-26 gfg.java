import java.util.*;
class Solution {
    public int[] stableMarriage(int[][] men, int[][] women) {
        int n = men.length;
        int[] result = new int[n];
        int[] womanPartner = new int[n];
        Arrays.fill(womanPartner, -1);
        int[] next = new int[n];
        int[][] rank = new int[n][n];
        for (int w = 0; w < n; w++) {
            for (int i = 0; i < n; i++) {
                rank[w][women[w][i]] = i;
            }
        }
        Queue<Integer> freeMen = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            freeMen.add(i);
        }
        while (!freeMen.isEmpty()) {
            int m = freeMen.poll();
            int w = men[m][next[m]];
            next[m]++;
            if (womanPartner[w] == -1) {
                womanPartner[w] = m;
                result[m] = w;
            } else {
                int m2 = womanPartner[w];
                if (rank[w][m] < rank[w][m2]) {
                    womanPartner[w] = m;
                    result[m] = w;
                    freeMen.add(m2);
                } else {
                    freeMen.add(m);
                }
            }
        }
        return result;
    }
}
