class Solution {
  public:
    void swapOne(vector<int> &arr, int N)
{
    for (int i = 0; i < N; i++) {
        if (arr[i] != i + 1) {
            int temp = arr[i];
            arr[i] = arr[temp - 1];
            arr[temp - 1] = temp;
            break;
        }
    }
}
    int counting(vector<int>&arr){
        int cnt=0;
        for(int i=0;i<arr.size();i++){
            if(arr[i]!=i+1){
                cnt++;
            }
        }
        return cnt;
    }
    bool checkSorted(vector<int> &arr) {
        int n=arr.size();
        int ans=counting(arr);
        if(ans==0 || ans==3){
            return true;
        }
        if(ans==4){
            swapOne(arr,n);
            swapOne(arr,n);
            return counting(arr)==0;
        }
        return false;
    }
};
