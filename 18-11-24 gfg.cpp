class Solution {
  public:
    void rotateArr(vector<int>& arr, int d) 
    {
        int n = arr.size();
        d = d % n;
        for(int i=0;i<n+d;i++)
        {
            if(i<d) arr.push_back(arr[i]);
            else arr[i-d] = arr[i];
        }
        while(d--) arr.pop_back();
    }
};
