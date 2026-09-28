class Solution {
    vector<int> seg;
    int merge(int a, int b) {
        return std::gcd(a, b);
    }
    void build(vector<int>& arr, int node, int l, int r) {
        if (l == r) {
            seg[node] = arr[l];
            return;
        }
        int mid = (l + r) / 2;
        build(arr, 2 * node, l, mid);
        build(arr, 2 * node + 1, mid + 1, r);
        seg[node] = merge(seg[2 * node], seg[2 * node + 1]);
    }
    void update(int node, int l, int r, int idx, int val) {
        if (l == r) {
            seg[node] = val;
            return;
        }
        int mid = (l + r) / 2;
        if (idx <= mid)
            update(2 * node, l, mid, idx, val);
        else
            update(2 * node + 1, mid + 1, r, idx, val);
        seg[node] = merge(seg[2 * node], seg[2 * node + 1]);
    }
    int query(int node, int l, int r, int ql, int qr) {
        if (r < ql || l > qr)
            return 0;
        if (ql <= l && r <= qr)
            return seg[node];
        int mid = (l + r) / 2;
        int left = query(2 * node, l, mid, ql, qr);
        int right = query(2 * node + 1, mid + 1, r, ql, qr);
        return merge(left, right);
    }
public:
    vector<int> processQueries(vector<int>& arr, vector<vector<int>>& queries) {
        int n = arr.size();
        seg.resize(4 * n);
        build(arr, 1, 0, n - 1);
        vector<int> ans;
        for (auto &q : queries) {
            if (q[0] == 0) {
                ans.push_back(query(1, 0, n - 1, q[1], q[2]));
            } 
            else {
                update(1, 0, n - 1, q[1], q[2]);
            }
        }
        return ans;
    }
};
