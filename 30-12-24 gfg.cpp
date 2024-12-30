class Solution {
  public:
    int findUnion(vector<int>& a, vector<int>& b) {
        set<int> s;
        for(int it:a){
            s.insert(it);
        }
        for(int it:b){
            s.insert(it);
        }
        return s.size();
    }
};
