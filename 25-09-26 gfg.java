import java.util.*;
class Solution {
    public int maxHeight(int[] height, int[] width, int[] length) {
        int n = height.length;
        int[][] boxes = new int[n * 6][3];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            int a = height[i];
            int b = width[i];
            int c = length[i];
            boxes[idx++] = new int[]{a, b, c};
            boxes[idx++] = new int[]{a, c, b};
            boxes[idx++] = new int[]{b, a, c};
            boxes[idx++] = new int[]{b, c, a};
            boxes[idx++] = new int[]{c, a, b};
            boxes[idx++] = new int[]{c, b, a};
        }
        Arrays.sort(boxes, (x, y) -> {
            if (x[0] != y[0]) {
                return Integer.compare(y[0], x[0]);
            }
            if (x[1] != y[1]) {
                return Integer.compare(y[1], x[1]);
            }
            return Integer.compare(y[2], x[2]);
        });
        int m = boxes.length;
        int[] dp = new int[m];
        int ans = 0;
        for (int i = m - 1; i >= 0; i--) {
            dp[i] = boxes[i][2];
            for (int j = i + 1; j < m; j++) {
                if (boxes[i][0] > boxes[j][0] &&
                    boxes[i][1] > boxes[j][1]) {
                    dp[i] = Math.max(
                        dp[i],
                        boxes[i][2] + dp[j]
                    );
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
