class Solution {
  public:
    Node* reverseKGroup(Node* head, int k) {
        if (!head || k == 1) return head;
        Node* curr = head;
        Node* prev = NULL;
        Node* next = NULL;
        int count = 0;
        Node* temp = head;
        while (temp && count < k) {
            temp = temp->next;
            count++;
        }
        curr = head;
        int c = 0;
        while (curr && c < count) {
            next = curr->next;
            curr->next = prev;
            prev = curr;
            curr = next;
            c++;
        }
        if (next != NULL) {
            head->next = reverseKGroup(next, k);
        }
        return prev;
    }
};
