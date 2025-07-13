import java.util.*;
class Solution {
    public int nonLisMaxSum(int[] arr) {
        int n = arr.length;
        int[] len = new int[n];
        int[] sum = new int[n];
        int maxLen = 1;
        int minLisSum = Integer.MAX_VALUE;
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            len[i] = 1;
            sum[i] = arr[i];
            totalSum += arr[i];
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    if (len[j] + 1 > len[i]) {
                        len[i] = len[j] + 1;
                        sum[i] = sum[j] + arr[i];
                    } else if (len[j] + 1 == len[i]) {
                        sum[i] = Math.min(sum[i], sum[j] + arr[i]);
                    }
                }
            }
            if (len[i] > maxLen) {
                maxLen = len[i];
                minLisSum = sum[i];
            } else if (len[i] == maxLen) {
                minLisSum = Math.min(minLisSum, sum[i]);
            }
        }
        return totalSum - minLisSum;
    }
}
