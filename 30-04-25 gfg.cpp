class Solution {
  public:
    int countNodesinLoop(Node *head) {
        if(head == NULL)
            return 0;
        Node* slow = head;
        Node* fast = head->next;
        while(fast != NULL && fast->next != NULL && slow != fast)
        {
            slow = slow->next;
            fast = fast->next->next;
        }
        if(fast == NULL || fast->next == NULL)
            return 0;
        int ans = 1;
        slow = slow->next;
        while(slow!=fast)
        {
            slow = slow->next;
            ans++;
        }
        return ans;
    }
};
