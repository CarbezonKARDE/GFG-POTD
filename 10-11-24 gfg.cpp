class Solution {
  public:
    vector<int> findUnion(vector<int> &a, vector<int> &b) {
        int i=0, j=0,s1=a.size(),s2=b.size();
        vector<int> ans;
        while(i<s1 && j<s2){
            if(a[i]==b[j]){
                ans.push_back(a[i]);
                i++;
                j++;
                
            }
            else if(a[i]<b[j]){
                ans.push_back(a[i]);
                i++;
            }
            else{
                ans.push_back(b[j]);
                j++;
            }
            
        }
        if(i<s1){
            while(i<s1){
                ans.push_back(a[i++]);
            }
        }
        else if(j<s2){
            while(j<s2){
                ans.push_back(b[j++]);
            }
        }
        return ans;
    }
};
