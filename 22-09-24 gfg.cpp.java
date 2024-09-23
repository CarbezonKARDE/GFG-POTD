class Solve {
    int[] findTwoElement(int arr[]) {
        int[]ans=new int[2];
        Arrays.sort(arr);
        for(int i=1;i<arr.length;i++){
            int k=i-1;
            if(arr[i]==arr[k]){
                ans[0]=arr[i];
                break;
            }
            else{
                continue;
            }
        }
        long n=arr.length;
        long expectedSum = (long) (n * (n + 1)) / 2; 
        long actualSum = 0;
        for (int num : arr) {
            actualSum += num;
        }
        ans[1] = (int) (expectedSum - (actualSum - ans[0]));
        return ans;
    }
}
