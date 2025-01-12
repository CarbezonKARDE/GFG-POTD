class Solution {
  public:
    int maxWater(vector<int> &arr) {
         int ans=0;
        vector<int>p,s(arr.size(),0);
        for(int i=0; i<arr.size(); i++){
            if(i==0){p.push_back(arr[i]); s[arr.size()-1]=arr[arr.size()-1];}
            else{
                p.push_back(max(p.back(), arr[i]));
                s[arr.size()-1-i]=max(arr[arr.size()-1-i], s[arr.size()-i]);
            }
        }
        for(int i=0; i<arr.size(); i++){
            ans+=min(p[i],s[i])-arr[i];
        }
        return ans;
    }
};
