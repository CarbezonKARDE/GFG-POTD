class Solution {
  public:
    int maxLength(string str) {
        int n=str.length();
        vector<int>arr(n,0);
        stack<int>st;
        for(int i=0; i<n; i++){
            if(str[i]=='(') st.push(i);
            else if(str[i]==')' && !st.empty()){
                arr[i]=1;
                arr[st.top()]=1;
                st.pop();
            }
        }
        int maxi=0;
        int count=0;
        for(int i=0; i<n; i++){
           if(arr[i]==0){
               count=0;
           }
           else count++;
           maxi=max(count,maxi);
        }
        return maxi;
    }
};
