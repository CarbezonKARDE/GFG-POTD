class Solution {
  public:
    Node* merge(Node* l1, Node* l2) {
        if (!l1) return l2;
        if (!l2) return l1;
        
        Node* head = nullptr;
        if (l1->data <= l2->data) {
            head = l1;
            head->next = merge(l1->next, l2);
        } else {
            head = l2;
            head->next = merge(l1, l2->next);
        }
        return head;
    }
    Node* getMiddle(Node* head) {
        if (!head || !head->next) return head;
        Node* slow = head;
        Node* fast = head->next;
        while (fast && fast->next) {
            slow = slow->next;
            fast = fast->next->next;
        }
        return slow;
    }
    Node* mergeSort(Node* head) {
        if (!head || !head->next) return head;
        Node* mid = getMiddle(head);
        Node* secondHalf = mid->next;
        mid->next = nullptr;
        Node* left = mergeSort(head);
        Node* right = mergeSort(secondHalf);
        return merge(left, right);
    }
};
