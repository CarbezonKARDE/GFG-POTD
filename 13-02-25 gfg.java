class Solution {
   public boolean findTarget(Node root, int target) {
            return findTargetBruteForceInorder(root, target);
        }
        private boolean findTargetBruteForceInorder(Node root, int target) {
            ArrayList<Integer> inorderNodesList = new ArrayList<>();
            inorderTraversal(inorderNodesList, root);
            return isPairSumEqualsToTargetExists(inorderNodesList, target);
        }
        private void inorderTraversal(ArrayList<Integer> inorderNodesList, Node root) {
            if (root == null) return;
            inorderTraversal(inorderNodesList, root.left);
            inorderNodesList.add(root.data);
            inorderTraversal(inorderNodesList, root.right);
        }
        private boolean isPairSumEqualsToTargetExists(ArrayList<Integer> list, int target) {
            if (list == null || list.isEmpty()) return false;
            int start = 0;
            int end = list.size() - 1;
            while (start < end) {
                int currSum = list.get(start) + list.get(end);
                if (currSum == target) return true;
                if (currSum > target) {
                    end--;
                } else {
                    start++;
                }
            }
            return false;
        }
}
