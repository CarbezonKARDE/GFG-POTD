import java.util.*;
class Solution {
    public int longestPath(String s, int[][] edges) {
        int n = s.length();
        if (n == 0) return 0;
        char[] col = s.toCharArray();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] parent = new int[n + 1];
        Arrays.fill(parent, -1);
        boolean[] visited = new boolean[n + 1];
        int[] order = new int[n];
        int idx = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        visited[1] = true;
        while (!stack.isEmpty()) {
            int u = stack.pop();
            order[idx++] = u;
            for (int v : adj.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    parent[v] = u;
                    stack.push(v);
                }
            }
        }
        int[] pureRed = new int[n + 1];
        int[] pureBlue = new int[n + 1];
        int[] chainRB = new int[n + 1];
        int[] chainBR = new int[n + 1];
        int ans = 1;
        for (int i = n - 1; i >= 0; i--) {
            int u = order[i];
            int par = parent[u];
            boolean isRed = (col[u - 1] == 'R');
            long bestLA = 0, secLA = 0; int idxLA = -2, idx2LA = -3;
            long bestRA = 0, secRA = 0; int idxRA = -2, idx2RA = -3;
            long bestLB = 0, secLB = 0; int idxLB = -2, idx2LB = -3;
            long bestRB = 0, secRB = 0; int idxRB = -2, idx2RB = -3;
            long bestPureRedChild = 0, bestPureBlueChild = 0;
            long bestChainRBChild = 0, bestChainBRChild = 0;
            for (int v : adj.get(u)) {
                if (v == par) continue;
                long lA = pureRed[v];
                long rA = isRed ? chainRB[v] : pureBlue[v];
                long lB = pureBlue[v];
                long rB = (!isRed) ? chainBR[v] : pureRed[v];
                if (lA > bestLA) { secLA = bestLA; idxLA = idxLA; bestLA = lA; idxLA = v; }
                else if (lA > secLA) secLA = lA;
                if (rA > bestRA) { secRA = bestRA; bestRA = rA; idxRA = v; }
                else if (rA > secRA) secRA = rA;
                if (lB > bestLB) { secLB = bestLB; bestLB = lB; idxLB = v; }
                else if (lB > secLB) secLB = lB;
                if (rB > bestRB) { secRB = bestRB; bestRB = rB; idxRB = v; }
                else if (rB > secRB) secRB = rB;
                bestPureRedChild = Math.max(bestPureRedChild, pureRed[v]);
                bestPureBlueChild = Math.max(bestPureBlueChild, pureBlue[v]);
                bestChainRBChild = Math.max(bestChainRBChild, chainRB[v]);
                bestChainBRChild = Math.max(bestChainBRChild, chainBR[v]);
            }
            long comboA = (idxLA != idxRA) ? bestLA + bestRA : Math.max(bestLA + secRA, bestRA + secLA);
            long comboB = (idxLB != idxRB) ? bestLB + bestRB : Math.max(bestLB + secRB, bestRB + secLB);
            ans = (int) Math.max(ans, Math.max(1 + comboA, 1 + comboB));
            if (isRed) {
                pureRed[u]  = (int) (1 + bestPureRedChild);
                pureBlue[u] = 0;
                chainRB[u]  = (int) (1 + bestChainRBChild);
                chainBR[u]  = (int) (1 + bestPureRedChild);
            } else {
                pureBlue[u] = (int) (1 + bestPureBlueChild);
                pureRed[u]  = 0;
                chainRB[u]  = (int) (1 + bestPureBlueChild);
                chainBR[u]  = (int) (1 + bestChainBRChild);
            }
        }
        return ans;
    }
}
