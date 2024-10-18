class Solution {
  public:
    int getSingle(vector<int>& arr) {
        int a = arr[0];
        for (int i = 1; i  < arr.size(); i++)
        {
            a = a ^ arr[i];
        }
        return a;
    }
};
