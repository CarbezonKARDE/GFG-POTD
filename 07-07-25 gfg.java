import java.util.*;
class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(n, -1));
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2 * n; i++) {
            int currentIndex = i % n;
            int currentElement = arr[currentIndex];
            while (!stack.isEmpty() && arr[stack.peek()] < currentElement) {
                int index = stack.pop();
                result.set(index, currentElement);
            }
            if (i < n) {
                stack.push(currentIndex);
            }
        }
        return result;
    }
}
