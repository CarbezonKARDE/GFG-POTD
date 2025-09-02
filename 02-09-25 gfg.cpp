class Solution {
  public:
    Node* swapKth(Node* head, int k) {
        if (!head) return head;
        int n = 0;
        Node* temp = head;
        while (temp) {
            n++;
            temp = temp->next;
        }
        if (k > n) return head;
        if (2*k - 1 == n) return head;
        Node* x_prev = nullptr;
        Node* x = head;
        for (int i = 1; i < k; i++) {
            x_prev = x;
            x = x->next;
        }
        Node* y_prev = nullptr;
        Node* y = head;
        for (int i = 1; i < n-k+1; i++) {
            y_prev = y;
            y = y->next;
        }
        if (x_prev) x_prev->next = y;
        if (y_prev) y_prev->next = x;
        Node* tempNext = x->next;
        x->next = y->next;
        y->next = tempNext;
        if (k == 1) head = y;
        if (k == n) head = x;
        return head;
    }
};
