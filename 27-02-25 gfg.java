class Solution {
    private final Stack<Integer> st;
    private int minValue;
    public Solution() {
        st = new Stack<Integer>();
        minValue = Integer.MAX_VALUE;
    }
    public void push(int x) {
        if (st.isEmpty()) {
            minValue = x;
        } else {
            if (x < minValue) {
                st.push(minValue);
                minValue = x;
            }
        }
        st.push(x);
    }
    public void pop() {
        if (st.isEmpty()) {
            return;
        }
        int peek = st.peek();
        st.pop();
        if (minValue == peek && !st.isEmpty()) {
            minValue = st.pop();
        }
    }
    public int peek() {
        if (st.isEmpty()) {
            return -1;
        }
        return st.peek();
    }
    public int getMin() {
        if (st.isEmpty()) {
            return -1;
        }
        return minValue;
    }
}
