class Solution {
  public:
    int kthElement(vector<int>& a, vector<int>& b, int k) {
        int n1=a.size();
        int n2=b.size();
        vector<int>temp;
        int left=0,right=0;
        while(left<n1 && right<n2){
            if(a[left]<b[right]){
                temp.push_back(a[left]);
                left++;
            }
            else{
                temp.push_back(b[right]);
                right++;
            } 
        }
        while(left<n1){
            temp.push_back(a[left]);
            left++;
        }
        while(right<n2){
            temp.push_back(b[right]);
            right++;
        }
        return temp[k-1];
    }
};
