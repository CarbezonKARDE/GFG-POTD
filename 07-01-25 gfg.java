class Solution {
    int countPairs(int arr[], int target) {
        int count=0,n=arr.length;
        int l=0,r=n-1;
        while(l<r){
            int sum=arr[l]+arr[r];
            if(sum==target){
                if(arr[l]==arr[r]){
                    count+=((r-l)*(r-l+1))/2;
                    break;
                } else {
                    int cnt1=1,cnt2=1;
                    while(arr[l]==arr[l+1] && l+1<r){
                        l++;
                        cnt1++;
                    }
                    while(arr[r]==arr[r-1] && l<r-1){
                        r--;
                        cnt2++;
                    }
                    l++;
                    r--;
                    count+=(cnt1*cnt2);
                }
                } else if(sum<target){
                    l++;
                } else{
                    r--;
                }
            }
        return count;
    }
}
