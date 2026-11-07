class Solution {
    public ArrayList<String> generateUsernames(String[] arr) {
        ArrayList<String> ans = new ArrayList<>();
        HashSet<String> used = new HashSet<>();
        HashMap<String, Integer> next = new HashMap<>();
        for (String s : arr) {
            used.add(s);
        }
        for (String s : arr) {
            if (!ans.contains(s) && used.contains(s)) {
            }
        }

        HashSet<String> assigned = new HashSet<>();

        for (String s : arr) {
            if (!assigned.contains(s)) {
                ans.add(s);
                assigned.add(s);
            } else {
                int suffix = next.getOrDefault(s, 1);
                String candidate = s + suffix;

                while (used.contains(candidate)) {
                    suffix++;
                    candidate = s + suffix;
                }

                ans.add(candidate);
                used.add(candidate);
                assigned.add(candidate);
                next.put(s, suffix + 1);
            }
        }

        return ans;
    }
}
