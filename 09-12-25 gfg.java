class Solution {
    public ArrayList<Integer> findDuplicates(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int val = Math.abs(arr[i]);
            int idx = val - 1;
            if (arr[idx] < 0) {
                res.add(val);
            } else {
                arr[idx] = -arr[idx];
            }
        }
        return res;
    }
}
