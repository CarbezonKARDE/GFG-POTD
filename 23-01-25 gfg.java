class Solution {
    public Node cloneLinkedList(Node head) {
        Node curr = head, tmp, tmp2, res;
        while (curr != null) {
            tmp = curr.next;
            curr.next = new Node(curr.data);
            curr.next.next = tmp;
            curr = tmp;
        }
        curr = head;
        while (curr != null) {
            if (curr.random != null) curr.next.random = curr.random.next;
            curr = curr.next.next;
        }
        curr = head;
        res = curr.next;
        while (curr != null) {
            tmp = curr.next;
            tmp2 = curr.next.next;
            tmp.next = tmp.next != null? tmp.next.next: null;
            curr.next = tmp2;
            curr = curr.next;
        }
        return res;
    }
}
