class Solution {
  public:
    bool canSplit(vector<int>& arr) {
      int n=arr.size();
   int sum=accumulate(arr.begin(),arr.end(),0);
      int i=0;
      int j=n-1;
     vector<int> leftsum(n,0);
      vector<int>rightsum(n,0);
      leftsum[0]=arr[0];
      rightsum[n-1]=arr[n-1];
     for(int i=1;i<n;i++){
         leftsum[i]=leftsum[i-1]+arr[i];
         rightsum[n-i-1]=rightsum[n-i]+arr[n-i-1];
     }
     for(int i=1;i<n;i++){
         if((leftsum[i-1]==rightsum[i])){
             return true;
         }
     }
      return false;
    }
};
