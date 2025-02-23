class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        Stack<Integer>st=new Stack<>();
        ArrayList<Integer>al=new ArrayList<>();
        al.add(-1);
        st.push(arr[arr.length-1]);
        for(int i=arr.length-2;i>=0;i--){
            int v=arr[i];
            while(!st.isEmpty() && st.peek()<=v){
                st.pop();
            }
            if(st.isEmpty()){
                al.add(0,-1);
            }
            else{
                al.add(0,st.peek());
            }
            st.push(v);
        }
        return al;
    }
}
