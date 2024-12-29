class Solution {
    public ArrayList<Integer> intersectionWithDuplicates(int[] a, int[] b) {
        HashSet<Integer> ans = new HashSet<>();
        HashSet<Integer> set = new HashSet<>();
        for(int ele : a)
            set.add(ele);
        for(int ele : b) {
            if(set.contains(ele))
                    ans.add(ele);
        }
        return new ArrayList<>(ans);
    }
}
