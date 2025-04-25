class Solution {
    static int majorityElement(int arr[]) {
        int temp = 1;
        Arrays.sort(arr);
        for(int i = 1; i < arr.length; i++) {
            if(temp > (arr.length / 2)) {
                return arr[i - 1]; 
            }
            else if(arr[i] == arr[i-1]) {
                temp++;
            }
            else {
                temp = 1;
            }
        }
        return temp > (arr.length / 2) ? arr[arr.length - 1] : -1;
    }
}
