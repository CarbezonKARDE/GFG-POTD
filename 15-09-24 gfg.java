class Solution
{
    Node prev=null;
    Node bToDLL(Node root){
	Node newLL =new Node(0);
	prev=newLL;
	inorder_traversal(root);
	Node head=newLL.right;
	head.left=null;
	return head;
    }
    void inorder_traversal(Node root){
        if(root==null) return;
        inorder_traversal(root.left);
        Node curr= new Node(root.data);
        prev.right=curr;
        curr.left=prev;
        prev=curr;
        inorder_traversal(root.right);
    }
}
