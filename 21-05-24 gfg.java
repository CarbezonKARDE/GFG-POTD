class Pair implements Comparable<Pair>{
    int diff;
    int ele;
    Pair(int d,int e){
        this.diff=d;
        this.ele=e;
    }
     public int compareTo(Pair other){
        if(this.diff!=other.diff){
            return other.diff-this.diff;
        }
        return this.ele-other.ele;   
     }
}
class Solution {
    int[] printKClosest(int[] arr, int n, int k, int x) {
        PriorityQueue<Pair> q=new PriorityQueue<Pair>();
        for(int ele:arr){
            if(ele==x)
            continue;
            q.add(new Pair(Math.abs(ele-x),ele));
            if(q.size()>k)
            q.remove();
        }
        int[] res=new int[k];
        int count=0;
        while(!q.isEmpty()){
            res[k-count-1]=q.peek().ele;
            q.remove();
            count++;
        }
        return res;
    }
}
