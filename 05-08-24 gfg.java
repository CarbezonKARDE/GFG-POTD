class Solution
{
    class TreeNode {
        Node node;
        int vertical;
        TreeNode(Node node, int vertical){
            this.node = node; 
            this.vertical = vertical; 
        }
    }
    public ArrayList <Integer> bottomView(Node root)
    {
        Queue<TreeNode> cu = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        cu.add(new TreeNode(root, 0));
        while(!cu.isEmpty()){
            TreeNode treeNode = cu.poll();
            Node node = treeNode.node;
            int vertical = treeNode.vertical;
            map.put(vertical, node.data);
            if(node.left != null) cu.add(new TreeNode(node.left, vertical - 1));
            if(node.right != null) cu.add(new TreeNode(node.right, vertical + 1));
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(Integer value: map.values()){
            res.add(value);
        }
        return res;
    }
}
