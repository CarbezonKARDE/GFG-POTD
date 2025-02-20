class Solution {
    public DLLNode sortDoubly(DLLNode node) {
        int i=0,j,c=0;
        DLLNode p=node;
        ArrayList<Integer>ans=new ArrayList<>();
        while(p!=null)
        {
            ans.add(p.data);
            p=p.next;
        }
        Collections.sort(ans);
        p=node;
        while(p!=null)
        {
            p.data=ans.get(i++);
            p=p.next;
        }
        return node;
    }
}
