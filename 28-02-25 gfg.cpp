class Solution {
  public:
    int evaluate(vector<string>& arr) {
        stack<int> st{};
        for(int i = 0; i < arr.size(); i++)
        {
            if(arr[i] != "+" && arr[i] != "-" && arr[i] != "*" && arr[i] != "/")
            {
                st.push(stoi(arr[i]));
            }
            else
            {
                int op1 = st.top();
                st.pop();
                int op2 = st.top();
                st.pop();
                if (arr[i] == "+")
                {
                    st.push(op1+op2);
                }
                else if (arr[i] == "-")
                {
                    st.push(op2-op1);
                }
                else if (arr[i] == "*")
                {
                    st.push(op1*op2);
                }
                else if (arr[i] == "/")
                {
                    st.push(op2/op1);
                }
            }
        }
        return st.top();
    }
};
