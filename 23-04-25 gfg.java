class Solution {
    public int[] singleNum(int[] arr) {
        int ar[] = new int[2];
        int idx = 0;
        int xor = 0;
        for(int i=0;i<arr.length;i++){
            xor ^= arr[i];
        }
        int differBit = xor&(-xor);
        int a = 0;
        int b = 0;
        for(int j=0;j<arr.length;j++){
            if((arr[j]&differBit) == 0){
                a ^= arr[j];
            }else{
                b ^= arr[j];
            }
        }
        ar[idx++] = a;
        ar[idx++] = b;
        Arrays.sort(ar);
        return ar;
    }
}
