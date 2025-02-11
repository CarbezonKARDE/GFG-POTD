class Solution {
    boolean isBST(Node root) {
        return isBSTUtil(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    boolean isBSTUtil(Node node, int min,int max){
        if(node==null) return true;
        if(node.data<=min||node.data>=max) return false;
        return isBSTUtil(node.left,min,node.data)&&
        isBSTUtil(node.right,node.data,max);
    }
}
