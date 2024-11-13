class Intersect {
    int intersectPoint(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return -1;
        }
        Node temp1 = head1, temp2 = head2;
        while (temp1 != temp2) {
            temp1 = (temp1 == null) ? head2 : temp1.next;
            temp2 = (temp2 == null) ? head1 : temp2.next;
        }
        return (temp1 != null) ? temp1.data : -1;
    }
}
