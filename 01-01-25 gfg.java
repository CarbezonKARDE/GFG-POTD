class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        Map<String, ArrayList<String>> umap = new HashMap<>();
        for (String s : arr) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            umap.computeIfAbsent(sortedStr, k -> new ArrayList<>()).add(s);
        }
        for (ArrayList<String> x : umap.values()) {
            result.add(x);
        }
        return result;
    }
}
