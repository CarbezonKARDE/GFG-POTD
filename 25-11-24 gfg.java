class Solution {
    int maxProduct(int[] arr) {
        int ans = Integer.MIN_VALUE;
        int prefix = 1, suffix = 1;
        for(int i = 0 ; i < arr.length ; i++){
            if(prefix == 0){
                prefix = 1;
            }
            if(suffix == 0){
                suffix = 1;
            }
            prefix *= arr[i];
            suffix *= arr[arr.length - i - 1];
            ans = Math.max(ans, Math.max(prefix, suffix));
        }
        return ans;
    }
}
