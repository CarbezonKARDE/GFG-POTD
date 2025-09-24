#include <bits/stdc++.h>
using namespace std;
class SpecialQueue {
    queue<int> q;
    deque<int> minDq, maxDq;
public:
    void enqueue(int x) {
        q.push(x);
        while (!minDq.empty() && minDq.back() > x) {
            minDq.pop_back();
        }
        minDq.push_back(x);
        while (!maxDq.empty() && maxDq.back() < x) {
            maxDq.pop_back();
        }
        maxDq.push_back(x);
    }
    void dequeue() {
        if (q.empty()) return;
        int val = q.front();
        q.pop();
        if (!minDq.empty() && minDq.front() == val) {
            minDq.pop_front();
        }
        if (!maxDq.empty() && maxDq.front() == val) {
            maxDq.pop_front();
        }
    }
    int getFront() {
        return q.front();
    }
    int getMin() {
        return minDq.front();
    }
    int getMax() {
        return maxDq.front();
    }
};
