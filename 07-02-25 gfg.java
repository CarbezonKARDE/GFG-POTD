class Solution {
    void solve(Node root,ArrayList<Integer> al)
    {
        if(root == null)
        return;
        solve(root.left,al);
        al.add(root.data);
        solve(root.right,al);
    }
    ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer> al = new ArrayList<>();
        solve(root,al);
        return al;
    }
}
