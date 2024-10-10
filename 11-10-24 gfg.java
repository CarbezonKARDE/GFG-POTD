class Solution {
    public List<Integer> rearrange(List<Integer> arr) {
        int i=0;
        while(i<arr.size()){
          if(arr.get(i)>=0 && i!=arr.get(i)) {
              int temp=arr.get(arr.get(i));
              arr.set(arr.get(i),arr.get(i));
              arr.set(i,temp);
          }
          else i++;
        }
        return arr;
    }
}
