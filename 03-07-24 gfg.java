class Solution {
    public Node removeAllDuplicates(Node head) {
        Node dummy=new Node(0);
        dummy.next=head;
        Node prev=dummy;
        Node curr=head;
        while(curr!=null){
            boolean isDup=false;
            while(curr.next!=null && curr.data==curr.next.data){
                curr=curr.next;
                isDup=true;
            }
            if(isDup){
                prev.next=curr.next;
            }
            else{
                prev=prev.next;
            }
            curr=curr.next;
        }
        return dummy.next;
    }
}
