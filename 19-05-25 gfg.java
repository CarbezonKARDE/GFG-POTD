class Solution {
    public ArrayList<Node> findPreSuc(Node root, int key) {
        Node pre = null, suc = null;
        Node curr = root;
        while (curr != null) {
            if (curr.data == key) {
                if (curr.left != null) {
                    pre = curr.left;
                    while (pre.right != null)
                        pre = pre.right;
                }
                if (curr.right != null) {
                    suc = curr.right;
                    while (suc.left != null)
                        suc = suc.left;
                }
                break;
            } else if (key < curr.data) {
                suc = curr;
                curr = curr.left;
            } else {
                pre = curr;
                curr = curr.right;
            }
        }
        ArrayList<Node> res = new ArrayList<>();
        res.add(pre);
        res.add(suc);
        return res;
    }
}
