class Solution {
  public:
    int maxStep(vector<int>& arr) {
        int len = 0;
        int maxi = 0;
        for(int i =0; i< arr.size()-1; i++){
            if(arr[i] < arr[i+1]){
                len++;
            }
            else{
                maxi = max(len, maxi);
                len = 0;
            }
        }
        maxi = max(maxi, len);
        return maxi;
    }
};
