Node* revLL(Node* head)
{
    Node* temp = head;
    Node* prev = NULL;
    Node* front = NULL;
    
    while(temp)
    {
        front = temp->next;
        temp->next = prev;
        prev = temp;
        temp = front;
    }
    return prev;
}

class Solution {
  public:
    Node* addOne(Node* head) {
        head = revLL(head);
        int carry =1, val = 0;
        Node* temp = head;
        Node* newHead;
        while (temp)
        {
            int x = temp->data;
            temp->data = (temp->data + carry) % 10;
            carry = (x + carry)  / 10;
            temp = temp->next;
        }
        head = revLL(head);
        
        if (carry > 0)
        {
            newHead = new Node (carry);
            newHead->next = head;
        }
        else 
            newHead = head;
            
        return newHead;
        
    }
};
