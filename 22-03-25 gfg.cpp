class Solution {
  public:
  int find(vector<int> &arr, int i, int n){
      int pre1 = 0, pre2 = 0;
      for(int j = i + 1; j<=n; j++){
          int loot = arr[j-1];
          int doNotLoot = pre1;
          if(j > 1) loot += pre2;
          pre2 = pre1;
          pre1 = max(loot, doNotLoot);
      }
      return pre1;
  }
    int maxValue(vector<int>& arr) {
        int n = arr.size();
        int w1 = find(arr,0, n-1);
        int w2 = find(arr, 1, n);
        return max(w1, w2);
    }
};
