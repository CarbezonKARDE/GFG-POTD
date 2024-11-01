class Solution {
    public Node sortedInsert(Node head, int valueToInsert) {
        Node newNode = new Node(valueToInsert);
        if (head == null) {
            return newNode;
        } else if (valueToInsert <= head.data) {
            newNode.next = head;
            head.prev = newNode;
            return newNode;
        }
        Node current = head;
        while (current.next != null && current.next.data < valueToInsert) {
            current = current.next;
        }
        newNode.next = current.next;
        newNode.prev = current;
        if (current.next != null) {
            current.next.prev = newNode;
        }
        current.next = newNode;
        return head;
    }
}
