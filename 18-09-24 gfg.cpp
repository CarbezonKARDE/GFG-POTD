class Solution{
    public:
    bool ispar(string x){
        stack<char>s;
        for(auto i = 0;i<x.size();i++){
            if(x[i] == '(' || x[i] == '{' || x[i] =='['){
                s.push(x[i]);
            }
            else{
                if(!s.empty() && x[i] == ')' && s.top() == '('){
                    s.pop();
                }
                else if (!s.empty() && x[i] == '}' && s.top() == '{'){
                    s.pop();
                }
                else if(!s.empty() && x[i] == ']' && s.top() == '['){
                    s.pop();
                } 
                else{
                    return false;
                }
            }
        }
        if (s.empty()){
            return true;
        }
    }
};
