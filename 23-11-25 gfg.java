class Solution {
    public int maxRemove(int[][] stones) {
        int n = stones.length;
        DisjointSet dsu = new DisjointSet(20005); 
        for (int[] s : stones) {
            int row = s[0];
            int col = s[1] + 10000;
            dsu.union(row, col);
        }
        HashSet<Integer> set = new HashSet<>();
        for (int[] s : stones) {
            int row = s[0];
            int col = s[1] + 10000;
            set.add(dsu.find(row));
            set.add(dsu.find(col));
        }
        return n - set.size();
    }
}
class DisjointSet {
    int[] parent, rank;
    DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
    }
    int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }
    void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) return;
        if (rank[px] < rank[py]) {
            parent[px] = py;
        } else if (rank[px] > rank[py]) {
            parent[py] = px;
        } else {
            parent[py] = px;
            rank[px]++;
        }
    }
}
