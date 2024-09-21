class Solution {
    Node copyList(Node head) {
        Node temp = head;
        while(temp != null) {
            Node newNode = new Node(temp.data);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = temp.next.next;
        }
        temp = head;
        while(temp != null) {
            if(temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }
        temp = head;
        Node ans = temp.next;
        Node ansHead = ans;
        while(temp != null) {
            temp.next = temp.next.next;
            if(ans.next != null) ans.next = ans.next.next;
            temp = temp.next;
            ans = ans.next;
        }
        return ansHead;
    }
}
