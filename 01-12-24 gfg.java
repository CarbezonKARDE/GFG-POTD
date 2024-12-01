class Solution {
    static char nonRepeatingChar(String s) {
        int[] arr = new int[26];
        for(char c: s.toCharArray()){
            arr[c-'a']++;
        }
        for(char c: s.toCharArray()){
            if(arr[c- 'a'] == 1){
                return c;
            }
        }
        return '$';
    }
}
