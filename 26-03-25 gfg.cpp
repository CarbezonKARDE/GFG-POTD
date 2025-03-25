class Solution {
  public:
    int solveMem(int i,string &s,set<string>&st,vector<int>&dp){
        if(i>=s.size())return true;
        if(dp[i]!=-1)return dp[i];
        string str;
        for(int idx=i;idx<s.size();idx++){
            str+=s[idx];
            if(st.count(str)){
            if(solveMem(idx+1,s,st,dp)) return dp[i]=true;
            }
        }
        return dp[i]=false;
    }
    int wordBreak(string &s, vector<string> &dictionary) {
        set<string>st(dictionary.begin(),dictionary.end());
        vector<int>dp(s.size()+1,-1);
        return solveMem(0,s,st,dp);
    }
};
