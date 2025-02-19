class Solution {
    Node mergeKLists(List<Node> arr) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> 
        a.data - b.data);
        for(Node curr : arr){
            pq.add(curr);
        }
        Node head = null;
        Node tail = null;
        while(!pq.isEmpty()){
            Node temp = pq.poll();
            if(head != null){
                tail.next = temp;
            }
            else{
                head = temp;
            }
            tail = temp;
            if(temp.next != null){
                pq.add(temp.next);
            }
        }
        return head;
    }
}
