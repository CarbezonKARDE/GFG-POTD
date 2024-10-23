class Solution {
    public int sumOfLastN_Nodes(Node head, int n) {
        int sum = 0;
        Node node = head;
        int count = 0;
        while(node != null){
            count++;
            node = node.next;
        }
        node = head;
        int index = count - n;
        int i = 0;
        while(node != null){
            i++;
            if(i > index){
                sum += node.data;
            }
            node = node.next;
        }
        return sum;
    }
}
