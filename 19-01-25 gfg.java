class Solution {
    public Node rotate(Node head, int k) {
          Node slow = head;
        Node temp =head;
        Node fast = head.next;
        int count=1;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            temp=temp.next.next;
            fast = fast.next.next;
            count++;
        }
        if(fast==null){
            count = (count*2)-1;
        }
        else{
            count = count*2;
            temp = fast;
        }
        int rotations = k%count;
        if(rotations==0 || count==1){
            return head;
        }
        int i=1;
        Node curnext = head.next;
        Node curr = head;
        while(i<rotations){
            curr=curr.next;
            curnext = curnext.next;
            i++;
        }
        temp.next = head;
        curr.next =null;
        return curnext;
    }
}
