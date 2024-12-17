class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int n = stalls.length, l=0, r=stalls[n-1]-stalls[0], ans=0;
        while(l<=r){
            int mid = l+(r-l)/2;
            int cows = cowsPlacedIn(stalls,mid);
            if(cows>=k){
                ans=mid;
                l=mid+1;
            }
            else    r=mid-1;
        }
        return ans;
    }
    static int cowsPlacedIn(int a[],int mid){
        int ans=0, prev=-1;
        for(int i:a){
            if(prev==-1 || i-prev>=mid){
                ans++;
                prev=i;
            }
        }
        return ans;
    }
}
