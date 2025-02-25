class Solution {
    public static int getMaxArea(int hist[]) {
        int n = hist.length;
        int[] ps = new int[n];
        int[] ns = new int[n];
        Deque<Integer> stack = new ArrayDeque<>(n);
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && hist[stack.peek()] >= hist[i]) {
                stack.pop();
            }
            ps[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for(int i = n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && hist[stack.peek()] >= hist[i]) {
                stack.pop();
            }
            ns[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        long maxArea = 0;
        for(int i = 0; i < n; i++) {
            int width = ns[i] - ps[i] - 1;
            maxArea = Math.max(maxArea, hist[i] * width);
        }
        return (int)maxArea;
    }
}
