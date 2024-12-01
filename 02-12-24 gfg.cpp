class Solution {
  public:
    vector<int> search(string& pat, string& txt) {
  vector<int>ans;
        char s = pat[0];
        for(int i=0;i<txt.size();i++){
            if(txt[i] == s && (i+pat.size()) <=txt.size()){
                string temp = txt.substr(i,pat.size());
                if(temp == pat)ans.push_back(i);
            }
        }
        return ans;
    }
};
