class Solution {
  public:
    int rotateDelete(vector<int> &v) {
        int k = 1;
       int n=v.size();
       while(k <= n){
           rotate(v.begin(), v.begin()+v.size()-1, v.end());
           v.erase(v.begin()+n-k);
           n = v.size();
           k++;
       }
       return v[0];
    }
};
