class Solution {
  public:
    vector<int> removeDuplicate(vector<int>& arr) {
       map<int,bool>mp;
       vector<int>v;
       for(auto i:arr){
           if(mp[i]==false){
               mp[i]=true;
               v.push_back(i);
           }
       }
       return v;
    }
};
