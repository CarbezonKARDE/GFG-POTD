class Solution {
  public:
    void removeLoop(Node* head) {
        if (!head) return;
        unordered_set<Node*> visited;
        Node* slow = head;
        Node* prev = nullptr;
        while (slow != nullptr) {
            if (visited.find(slow) != visited.end()) {
                prev->next = nullptr;
                return;
            }
            visited.insert(slow);
            prev = slow;
            slow = slow->next;
        }
    }
};
