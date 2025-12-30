class Solution {
  private:
    Node* reverse(Node* head) {
        Node* prev = NULL;
        while (head) {
            Node* next = head->next;
            head->next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
  public:
    Node* addTwoLists(Node* head1, Node* head2) {
        head1 = reverse(head1);
        head2 = reverse(head2);
        int carry = 0;
        Node* dummy = new Node(0);
        Node* curr = dummy;
        while (head1 || head2 || carry) {
            int sum = carry;
            if (head1) {
                sum += head1->data;
                head1 = head1->next;
            }
            if (head2) {
                sum += head2->data;
                head2 = head2->next;
            }
            carry = sum / 10;
            curr->next = new Node(sum % 10);
            curr = curr->next;
        }
        Node* result = reverse(dummy->next);
        while (result && result->data == 0 && result->next) {
            result = result->next;
        }
        return result;
    }
};
