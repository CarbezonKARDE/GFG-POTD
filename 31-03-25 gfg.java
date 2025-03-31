class Solution {
    public int maxPartitions(String s) {
        HashMap <Character,Integer> hmap=new HashMap<>();
        for(int i=0;i<s.length();i++){
            hmap.put(s.charAt(i),s.lastIndexOf(s.charAt(i)));
        }
        ArrayList <Integer> ans=new ArrayList<>();
        int size=0,end=0;
        for(int i=0;i<s.length();i++){
            size+=1;
            int lastIndex=hmap.get(s.charAt(i));
            end=Math.max(end,lastIndex);
            if(i==end){
                ans.add(size);
                size=0;
            }
        }
        return ans.size();
    }
}
