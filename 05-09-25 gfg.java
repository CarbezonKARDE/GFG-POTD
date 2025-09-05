class Solution {
    public Node segregate(Node head) {
        if (head == null || head.next == null) return head;
        Node zeroHead = new Node(-1), zeroTail = zeroHead;
        Node oneHead = new Node(-1), oneTail = oneHead;
        Node twoHead = new Node(-1), twoTail = twoHead;
        Node curr = head;
        while (curr != null) {
            if (curr.data == 0) {
                zeroTail.next = curr;
                zeroTail = zeroTail.next;
            } else if (curr.data == 1) {
                oneTail.next = curr;
                oneTail = oneTail.next;
            } else {
                twoTail.next = curr;
                twoTail = twoTail.next;
            }
            curr = curr.next;
        }
        zeroTail.next = (oneHead.next != null) ? oneHead.next : twoHead.next;
        oneTail.next = twoHead.next;
        twoTail.next = null;
        return zeroHead.next;
    }
}
