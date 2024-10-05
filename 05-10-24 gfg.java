class Solution {
    public long findSmallest(int[] arr) {
        int res = 1;
        for(int i=0;i<=arr.length-1;i++){
            if(res<arr[0]){
                return res;
            }
            if(arr[i]>res){
                break;
            }else{
                res = res + arr[i];
            }
        }
        return res;
    }
}
