class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        ArrayList<Integer> res = new ArrayList<>();
        int maxVal = 100000;  
        int[] freq = new int[maxVal + 1];
        int distinct = 0;
        for (int i = 0; i < k; i++) {
            if (freq[arr[i]] == 0) distinct++;
            freq[arr[i]]++;
        }
        res.add(distinct);
        for (int i = k; i < arr.length; i++) {
            int outgoing = arr[i - k];
            int incoming = arr[i];
            freq[outgoing]--;
            if (freq[outgoing] == 0) distinct--;
            if (freq[incoming] == 0) distinct++;
            freq[incoming]++;
            res.add(distinct);
        }
        return res;
    }
}
