class Solution {
    public static long[] productExceptSelf(int nums[]) {
        // code here
        long [] arr=new long[nums.length];
        Arrays.fill(arr,0);
        long product=1;
        boolean zero=false;
        int count0=0;
        for(int ob:nums){
            if(ob == 0){
                zero=true;
                count0++;
                if(count0>1)return arr;
            }
            else
                product*=ob;
        }
        
        
        for(int i=0;i<nums.length;i++){
            if(zero == true && nums[i]==0){
                arr[i]=product;
            }
            else if(zero==true){
                continue;
            } else {
                 arr[i]=(long)(product/nums[i]);
            }
           
        }
        
        return arr;
    }
}
