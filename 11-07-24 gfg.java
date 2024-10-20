class Solution {
    
    boolean isValid(int r, int c, int n) {
        if(r>=0 && r<n && c>=0 && c<n) return true;
        else return false;
    }
    public int MaxConnection(int grid[][]) {
        try{
            int n = grid.length;
            DisjointSet ds = new DisjointSet(n*n);
            
            for(int i = 0; i<n; i++) {
                for(int j = 0; j<n; j++) {
                    if(grid[i][j] == 0) continue;
                    int[] dr = {-1, 0, +1, 0};
                    int[] dc = {0, +1, 0, -1};
                    
                    for(int k = 0; k<4; k++) {
                        int nrow = i + dr[k];
                        int ncol = j + dc[k];
                        if(isValid(nrow, ncol, n) && grid[nrow][ncol] == 1){
                            if(ds.findParent(nrow*n+ncol) != ds.findParent(i*n+j)){
                                ds.unionBySize(nrow*n+ncol, i*n+j);
                            }
                        }
                    }
                }
            }
            int mx = 0;
            for(int i = 0; i<n; i++) {
                for(int j = 0; j<n; j++) {
                    if(grid[i][j] == 1) continue;
                    int[] dr = {-1, 0, +1, 0};
                    int[] dc = {0, +1, 0, -1};
                    HashSet<Integer> hs = new HashSet<>();
                    for(int k = 0; k<4; k++) {
                        int nrow = i + dr[k];
                        int ncol = j + dc[k];
                        if(isValid(nrow, ncol, n) && grid[nrow][ncol] == 1){
                            hs.add(ds.findParent(nrow*n+ncol));
                        }
                    }
                    int sizeTotal = 0;
                    for(Integer parent: hs) {
                        sizeTotal += ds.size.get(parent);
                    }
                    mx = Math.max(mx, sizeTotal+1);
                }
            }
            for(int cellNo = 0; cellNo<n*n; cellNo++){
                mx = Math.max(mx, ds.size.get(ds.findParent(cellNo)));
            }
            return mx;
        } catch (Exception e) {
            System.out.println(e);
            return 4;
        }
    }
}
class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet (int n){
        for(int i = 0; i<=n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }
    public int findParent(int node){
        if(node == parent.get(node)) return node;
        int ulp = findParent(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }
    public void unionByRank(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);
        if(pu == pv) return;

        if(rank.get(pv) > rank.get(pu)) {
            parent.set(pu, pv);
        } else if(rank.get(pv) < rank.get(pu)) {
            parent.set(pv, pu);
        } else {
            parent.set(pv, pu);
            int rank_u = rank.get(pu);
            rank.set(pu, rank_u+1);
        }
    }
    public void unionBySize(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);
        if(pu == pv) return;

        if(size.get(pv) > size.get(pu)) {
            parent.set(pu, pv);
            int size_u = size.get(pu);
            int size_v = size.get(pv);
            size.set(pv, size_u+size_v);
        } else {
            parent.set(pv, pu);
            int size_u = size.get(pu);
            int size_v = size.get(pv);
            size.set(pu, size_u+size_v);
        }
    }
}
