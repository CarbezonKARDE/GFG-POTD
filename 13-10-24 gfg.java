class Solution {
    public void deleteAlt(Node head) {
        int idx=1;
        Node temp = head;
        Node prev= null;
        while(temp!=null)
        {
            prev=temp;
            if(idx%2!=0)
            {
                if(temp.next==null)
                {
                    break;
                }
                temp.next = temp.next.next;
            }
            idx+=2;
            temp = temp.next;
        }
    }
}
