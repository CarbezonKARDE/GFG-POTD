class Solution {
    public int kthMissing(int[] arr, int k) {
         int missingCount = 0; 
        int currentNumber = 1; 
        int index = 0; 
        while (true) {
            if (index < arr.length && arr[index] == currentNumber) {
               index++;
            } else {
                missingCount++;
                if (missingCount == k) {
                    return currentNumber;
                }
            }
            currentNumber++;
        }
    }
}
