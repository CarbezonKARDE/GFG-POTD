class Solution {
  public:
    void pushZerosToEnd(vector<int>& arr) {
         int n =arr.size();
    vector<int>s1;
    for (int i=0;i<n;i++){
        if (arr[i]!=0){
               s1.push_back(arr[i]);
        }
    }
    for (int i=0;i<n;i++){
        if (arr[i]==0){
               s1.push_back(arr[i]);
        }
    }
    arr=s1;
    }
};
