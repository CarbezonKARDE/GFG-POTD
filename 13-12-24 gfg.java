class Solution {
    public int findMin(int[] arr) {
        int n=arr.length,min=Integer.MAX_VALUE,low=0,high=n-1;
        while(low<high)
        {
            int mid=(low+high)/2;
            if(arr[low]<=arr[mid])
            {
                if(min>arr[low])
                min=arr[low];
                low=mid+1;
            }
            else if(arr[low]>arr[mid])
            {
                if(min>arr[mid])
                min=arr[mid];
                high=mid-1;
            }
        }
        if(min>arr[low])
                min=arr[low];
        if(min>arr[high])
            min=arr[high];
        return min;
    }
}
