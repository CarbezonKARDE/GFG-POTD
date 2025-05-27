import java.util.*;
class Solution {
    int index = 0;
    public ArrayList<Integer> leafNodes(int[] preorder) {
        ArrayList<Integer> leaves = new ArrayList<>();
        index = 0;
        findLeaves(preorder, leaves, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return leaves;
    }
    private void findLeaves(int[] preorder, ArrayList<Integer> leaves, int min, int max) {
        if (index >= preorder.length)
            return;
        int val = preorder[index];
        if (val < min || val > max)
            return;
        index++;
        int currentIndex = index;
        findLeaves(preorder, leaves, min, val - 1);
        findLeaves(preorder, leaves, val + 1, max);
        if (index == currentIndex)
            leaves.add(val);
    }
}
