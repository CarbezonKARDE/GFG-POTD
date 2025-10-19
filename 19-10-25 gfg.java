import java.util.*;
class Solution {
    public ArrayList<Integer> getKClosest(Node root, int target, int k) {
        ArrayList<Integer> inorderList = new ArrayList<>();
        inorderTraversal(root, inorderList);
        Collections.sort(inorderList, (a, b) -> {
            int diffA = Math.abs(a - target);
            int diffB = Math.abs(b - target);
            if (diffA == diffB) return a - b;
            return diffA - diffB;
        });
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < k && i < inorderList.size(); i++) {
            result.add(inorderList.get(i));
        }
        return result;
    }
    private void inorderTraversal(Node root, ArrayList<Integer> list) {
        if (root == null) return;
        inorderTraversal(root.left, list);
        list.add(root.data);
        inorderTraversal(root.right, list);
    }
}
