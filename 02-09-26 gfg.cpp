class Solution {
  public:
    int solve(int n, string s) {
        vector<int> state(26, 0);
        int occupied = 0;
        int rejected = 0;
        for (char c : s) {
            int id = c - 'A';
            if (state[id] == 0) {
                if (occupied < n) {
                    state[id] = 1;
                    occupied++;
                } else {
                    state[id] = 2;
                    rejected++;
                }
            } 
            else {
                if (state[id] == 1) {
                    occupied--;
                }
                state[id] = 3;
            }
        }
        return rejected;
    }
};
