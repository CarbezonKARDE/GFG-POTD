#include <bits/stdc++.h>
using namespace std;
class Solution {
  public:
    int evaluatePostfix(vector<string>& arr) {
        stack<long long> st;
        for (auto &token : arr) {
            if (token == "+" || token == "-" || token == "*" || token == "/" || token == "^") {
                long long a = st.top(); st.pop();
                long long b = st.top(); st.pop();
                long long res = 0;
                if (token == "+") res = b + a;
                else if (token == "-") res = b - a;
                else if (token == "*") res = b * a;
                else if (token == "/") {
                    if (a == 0) throw runtime_error("Division by zero");
                    res = b / a;
                    if ((b % a != 0) && ((b < 0) ^ (a < 0))) res -= 1;
                }
                else if (token == "^") {
                    res = pow(b, a);
                }
                
                st.push(res);
            } else {
                st.push(stoll(token));
            }
        }
        return (int)st.top();
    }
};
