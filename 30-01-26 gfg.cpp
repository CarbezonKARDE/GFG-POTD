class Solution {
  public:
    void rearrangeQueue(queue<int> &q) {
        int n = q.size() / 2;
        queue<int> firstHalf;
        for(int i = 0; i < n; i++) {
            firstHalf.push(q.front());
            q.pop();
        }
        while(!firstHalf.empty()) {
            q.push(firstHalf.front());
            firstHalf.pop();
            q.push(q.front());
            q.pop();
        }
    }
};
