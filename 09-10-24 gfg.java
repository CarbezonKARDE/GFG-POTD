class Solution {
    static Node construct(int arr[][]) {
        int n = arr.length;
        Node head = new Node(arr[0][0]); 
        Node curr = head;
        Node nextRow = null;
        for (int i = 0; i < n; i++) {
            curr = (i == 0) ? head : nextRow;  
            for (int j = 0; j < n; j++) {
                Node right = null;
                Node down = null;
                if ((j + 1) < n) right = new Node(arr[i][j + 1]);
                if ((i + 1) < n) down = new Node(arr[i + 1][j]);
                if (j == 0 && down != null) nextRow = down;
                curr.right = right;
                curr.down = down;
                curr = curr.right != null ? curr.right : nextRow;
            }
        }
        return head;
    }
}
