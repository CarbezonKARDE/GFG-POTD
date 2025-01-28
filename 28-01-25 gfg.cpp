class Solution {
  public:
  void f(string s,vector<int> &vis, set<string> &ans,string t){
      int n=s.size();
      if(t.size()==n){
          ans.insert(t);
          return;
      }
      for(int i=0;i<n;i++){
          if(vis[i]==0){
              vis[i]=1;
            //   t+=s[i];
            string tt=t+s[i];
             f(s,vis,ans,tt);
            //   t.popback();
            vis[i]=0;
          }
      }
      return;
  }
    vector<string> findPermutation(string &s) {
        int n=s.size();
        vector<int> vis(n,0);
        set<string> ans;
        string t="";
        f(s,vis,ans,t);
        vector<string> a;
        for(auto it:ans){
            a.push_back(it);
        }
        return a;
    }
};
