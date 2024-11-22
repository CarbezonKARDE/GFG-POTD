class Solution {
    public int getMinDiff(int k, int[] arr) {
        Arrays.sort(arr);
        int n=arr.length;
        int min=arr[0];
        int max=arr[n-1];
        int x=max-min;
        for(int i=1;i<n;i++){
            min=Math.min(arr[0]+k,arr[i]-k);
            max=Math.max(arr[n-1]-k,arr[i-1]+k);
            x=Math.min(x,max-min);
        }
        return x;
    }
}
