class Solution {
    public int longestUniqueSubstr(String s) {
        int ans = 0;
        int[] arr = new int[26];
        int i = 0 , j = 0;
        while (j < s.length()){
            if(arr[s.charAt(j) - 'a'] == 0){
                arr[s.charAt(j) - 'a']++;
                ans = Math.max(ans, j - i + 1);
                j++;
            }else{
               arr[s.charAt(i) - 'a']--;
               i++;
            }
        }
        return ans;
    }
}
