class Solution {
  public:
bool isValid(string str) {
    int count = 0;
    string segment;
    for (char c : str) {
        if (c == '.') {
            if (segment.empty() || segment.size() > 3 || segment[0] == '0' && segment.size() > 1 || stoi(segment) > 255) {
                return false;
            }
            segment.clear();
            count++;
        } else {
            segment += c;
        }
    }

    if (segment.empty() || segment.size() > 3 || segment[0] == '0' && segment.size() > 1 || stoi(segment) > 255) {
        return false;
    }
    count++;

    return count == 4;
}
};
