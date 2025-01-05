class Solution {
    int countPairs(int arr[], int target) {
        int cnt=0;
        Arrays.sort(arr);
        int l=0,h=arr.length-1;
        while(l<h){
            if(arr[l]+arr[h]<target){
                cnt+=(h-l);
                l++;
            }else{
                h--;
            }
        }
        return cnt;
    }
}
