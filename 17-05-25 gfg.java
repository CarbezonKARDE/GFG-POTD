class Solution {
    public ArrayList<Integer> sortArray(int[] arr, int A, int B, int C) {
        int n = arr.length;
        int[] result = new int[n];

        int left = 0, right = n - 1;
        int index = A >= 0 ? n - 1 : 0;
        while (left <= right) {
            int x1 = arr[left];
            int x2 = arr[right];
            int val1 = A * x1 * x1 + B * x1 + C;
            int val2 = A * x2 * x2 + B * x2 + C;
            if (A >= 0) {
                if (val1 > val2) {
                    result[index--] = val1;
                    left++;
                } else {
                    result[index--] = val2;
                    right--;
                }
            } else {
                if (val1 < val2) {
                    result[index++] = val1;
                    left++;
                } else {
                    result[index++] = val2;
                    right--;
                }
            }
        }
        ArrayList<Integer> finalResult = new ArrayList<>(n);
        for (int val : result) {
            finalResult.add(val);
        }
        return finalResult;
    }
}
