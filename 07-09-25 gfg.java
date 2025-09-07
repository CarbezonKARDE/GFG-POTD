class Solution {
    Node mergeKLists(Node[] arr) {
        if (arr == null || arr.length == 0) return null;
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.data - b.data);
        for (Node head : arr) {
            if (head != null) pq.offer(head);
        }
        Node dummy = new Node(0);
        Node tail = dummy;
        while (!pq.isEmpty()) {
            Node min = pq.poll();
            tail.next = min;
            tail = tail.next;

            if (min.next != null) {
                pq.offer(min.next);
            }
        }
        return dummy.next;
    }
}
