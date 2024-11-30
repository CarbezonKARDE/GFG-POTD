class Solution {
  public:
    bool areAnagrams(string& s1, string& s2) {
        vector<int>st1(26, 0);
        vector<int>st2(26, 0);
        for(auto it : s1){
            st1[it-'a']++;
        }
        for(auto it : s2){
            st2[it-'a']++;
        }
        for(int i=0; i<26; i++){
            if(st1[i] != st2[i]){
                return false;
            }
        }
        return true;
    }
};
