class Solution {
    public int pairsViolatingBST(Node root) {
        List<Integer> inorder = new ArrayList<>();
        inorderTraversal(root, inorder);
        return countInversions(inorder);
    }

    private void inorderTraversal(Node node, List<Integer> list) {
        if (node == null) return;
        inorderTraversal(node.left, list);
        list.add(node.data);
        inorderTraversal(node.right, list);
    }

    private int countInversions(List<Integer> arr) {
        int n = arr.size();
        int[] temp = new int[n];
        return mergeSortAndCount(arr, temp, 0, n - 1);
    }

    private int mergeSortAndCount(List<Integer> arr, int[] temp, int left, int right) {
        int invCount = 0;
        if (left < right) {
            int mid = left + (right - left) / 2;
            invCount += mergeSortAndCount(arr, temp, left, mid);
            invCount += mergeSortAndCount(arr, temp, mid + 1, right);
            invCount += mergeAndCount(arr, temp, left, mid, right);
        }
        return invCount;
    }

    private int mergeAndCount(List<Integer> arr, int[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;
        int invCount = 0;

        while (i <= mid && j <= right) {
            if (arr.get(i) <= arr.get(j)) {
                temp[k++] = arr.get(i++);
            } else {
                invCount += (mid - i + 1);
                temp[k++] = arr.get(j++);
            }
        }

        while (i <= mid) {
            temp[k++] = arr.get(i++);
        }
        while (j <= right) {
            temp[k++] = arr.get(j++);
        }

        for (i = left; i <= right; i++) {
            arr.set(i, temp[i]);
        }

        return invCount;
    }
}
