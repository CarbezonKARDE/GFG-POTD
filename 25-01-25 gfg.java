class Solution {
    public static Node findFirstNode(Node head) {
        if(head==null || head.next==head) return head;
        Node s =head,f=head;
        while(f!=null && f.next!=null){
            f=f.next.next;
            s=s.next;
            if(s==f){
                f=head;
                while(s!=f){
                    s=s.next;
                    f=f.next;
                }
                return f;
            }
        }
        return null;
    }
}
