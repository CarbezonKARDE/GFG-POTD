class Solution {
    static int merge(int[] arr,int low,int mid,int high){
        int l=low,r=mid+1;
        ArrayList<Integer> temp=new ArrayList<>();
        int c=0;
        while(l<=mid && r<=high){
            if(arr[l]<=arr[r]){
                temp.add(arr[l]);
                l++;
            }
            else{
                c+=(mid-l+1);
                temp.add(arr[r]);
                r++;
            }
        }
        while(l<=mid){
            temp.add(arr[l]);
            l++;
        }
        while(r<=high){
            temp.add(arr[r]);
            r++;
        }
        for(int i=low;i<=high;i++){
            arr[i]=temp.get(i-low);
        }
        return c;
           
        }
    static int mergesort(int[] arr,int low,int high){
        int c=0;
        if(low>=high) return c;
        int mid=low+(high-low)/2;
        c+=mergesort(arr,low,mid);
        c+=mergesort(arr,mid+1,high);
        c+=merge(arr,low,mid,high);
        return c;
    }
    static int inversionCount(int arr[]) {
         return mergesort(arr,0,arr.length-1);
    }
}
