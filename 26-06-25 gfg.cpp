#include <bits/stdc++.h>
using namespace std;
class Solution {
  public:
    int minValue(string &s, int k) {
        unordered_map<char, int> freq;
        for (char ch : s) {
            freq[ch]++;
        }
        priority_queue<int> maxHeap;
        for (auto &entry : freq) {
            maxHeap.push(entry.second);
        }
        while (k-- && !maxHeap.empty()) {
            int top = maxHeap.top();
            maxHeap.pop();
            if (top > 1) {
                maxHeap.push(top - 1);
            }
        }
        int result = 0;
        while (!maxHeap.empty()) {
            int f = maxHeap.top();
            maxHeap.pop();
            result += f * f;
        }
        return result;
    }
};
