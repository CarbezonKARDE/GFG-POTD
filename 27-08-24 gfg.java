class Solution {
  public:
    int findMaxDiff(vector<int> &arr) {
        vector<int>ls;
        vector<int>rs;
        int k=0;
        for(int i=0;i<arr.size();i++)
        {
          k=i-1;
          while(k>=0)
          {
              if(arr[k]<arr[i])
              {
                ls.push_back(arr[k]);
                break;
              }
              else
              k=k-1;
          }
          if(ls.size()==i)
          {
            ls.push_back(0);
          }
       }
       for(int i=0;i<arr.size();i++)
        {
          k=i+1;
          while(k<arr.size())
          {
              if(arr[k]<arr[i])
              {
                rs.push_back(arr[k]);
                break;
              }
              else
              k=k+1;
          }
          if(rs.size()==i)
          {
            rs.push_back(0);
          }
       }
    vector<int>ans;
    int t=0;
    for(int i =0;i<ls.size();i++)
    {
        t=abs(ls[i]-rs[i]);
        ans.push_back(t);
    }
    int j=0;
    j=*max_element(ans.begin(), ans.end());
    return j;
    
    
}};
