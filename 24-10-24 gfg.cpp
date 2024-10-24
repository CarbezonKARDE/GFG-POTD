class Solution {
  public:
    vector<int> modifyAndRearrangeArray(vector<int> &arr) {
          vector<int> v;
        for(int i=0;i<arr.size();i++){
            if(arr[i]==arr[i+1]){
                v.push_back(arr[i]*2);
                i++;
            }
            else if(arr[i]==0) continue;
            else{
                v.push_back(arr[i]);
            }
        }
        int n=arr.size();
        int m=v.size();
        int j=n-m;
        int i=0;
        while(i<j){
            v.push_back(0);
            i++;
        }
        return v;
    }
};
