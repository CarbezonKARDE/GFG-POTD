class Solution {
    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
    public boolean palindromePair(String[] arr) {

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
            int n = s.length();
            for (int cut = 0; cut <= n; cut++) {
                String left = s.substring(0, cut);
                String right = s.substring(cut);
                if (isPalindrome(left)) {
                    String revRight = new StringBuilder(right).reverse().toString();
                    if (map.containsKey(revRight) && map.get(revRight) != i) {
                        return true;
                    }
                }
                if (cut != n && isPalindrome(right)) {
                    String revLeft = new StringBuilder(left).reverse().toString();
                    if (map.containsKey(revLeft) && map.get(revLeft) != i) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
