class Solution {
    static int subArraySum(int arr[], int tar) {
        int good = 0;
        long sum = 0;
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        
        for(int num : arr) {
            sum += num;
            good += map.getOrDefault(sum - tar, 0);
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return good;
    }
}
