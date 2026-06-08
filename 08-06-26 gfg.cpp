class Solution {
  public:
    Node* reverseList(Node* head) {
        Node* prev = nullptr;
        Node* curr = head;
        while (curr) {
            Node* nextNode = curr->next;
            curr->next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
    Node *compute(Node *head) {
        if (!head || !head->next) return head;
        head = reverseList(head);
        int mx = head->data;
        Node* curr = head;
        while (curr && curr->next) {
            if (curr->next->data < mx) {
                Node* temp = curr->next;
                curr->next = temp->next;
                delete temp;
            } else {
                curr = curr->next;
                mx = curr->data;
            }
        }
        return reverseList(head);
    }
};
