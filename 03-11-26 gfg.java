class Solution {
    static class DSU {
        int[] parent;
        int[] size;

        DSU(int n) {
            parent = new int[n + 1];
            size = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        long union(int u, int v) {
            int pu = find(u);
            int pv = find(v);

            if (pu == pv) return 0;

            if (size[pu] < size[pv]) {
                int temp = pu;
                pu = pv;
                pv = temp;
            }

            long paths = (long) size[pu] * size[pv];

            parent[pv] = pu;
            size[pu] += size[pv];

            return paths;
        }
    }

    public ArrayList<Integer> maximumWeight(
            int n, int[][] edges, int[] queries) {

        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));

        int m = queries.length;

        int[][] q = new int[m][2];

        for (int i = 0; i < m; i++) {
            q[i][0] = queries[i];
            q[i][1] = i;
        }

        Arrays.sort(q, (a, b) -> Integer.compare(a[0], b[0]));

        DSU dsu = new DSU(n);

        long[] ans = new long[m];

        long count = 0;
        int j = 0;

        for (int i = 0; i < m; i++) {
            int limit = q[i][0];

            while (j < edges.length && edges[j][2] <= limit) {
                count += dsu.union(edges[j][0], edges[j][1]);
                j++;
            }

            ans[q[i][1]] = count;
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            result.add((int) ans[i]);
        }

        return result;
    }
}
