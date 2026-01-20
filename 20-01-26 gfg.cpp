class Solution {
    stack<char> doc;
    stack<char> redoSt;
public:
    void append(char x) {
        doc.push(x);
        while (!redoSt.empty()) redoSt.pop();
    }
    void undo() {
        if (!doc.empty()) {
            redoSt.push(doc.top());
            doc.pop();
        }
    }
    void redo() {
        if (!redoSt.empty()) {
            doc.push(redoSt.top());
            redoSt.pop();
        }
    }
    string read() {
        string result;
        stack<char> temp = doc;
        while (!temp.empty()) {
            result.push_back(temp.top());
            temp.pop();
        }
        reverse(result.begin(), result.end());
        return result;
    }
};
