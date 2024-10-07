class Solution {
    static Node insert(Node head, int data) {
        Node a = new Node(data);
        a.npx = head;
        return a;
    }
    static ArrayList<Integer> getList(Node head) {
        ArrayList<Integer> ans = new ArrayList<>();
        Node a = head;
        while(a!=null){
            ans.add(a.data);
            a = a.npx;
        }
        return ans;
    }
}
