class Solution {
  public:
    vector<int> previousLargerElement(vector<int>& arr) {
    int n = arr.size();
    vector<int> result(n); 
    stack<int> s;           
    for (int i = 0; i < n; ++i) {
        while (!s.empty() && s.top() < arr[i]) {
            s.pop();
        }
        if (s.empty()) {
            result[i] = -1;
        } else {
            result[i] = s.top();
        }
        s.push(arr[i]);
    }
    return result;
}
    int countBuildings(vector<int> &h) {
        vector<int> prev = previousLargerElement(h);
        int cnt = 0;
        for(auto &i : prev){
            if(i == -1){
                cnt++;
            }
        }
        return cnt;
    }
};
