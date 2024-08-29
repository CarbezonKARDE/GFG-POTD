class Solution {
  public:
    int countNodesinLoop(Node *head) {
         Node * temp = head;
        int count = 0;
        while(temp!=NULL && temp->data>=0){
            temp->data = 0-(temp->data);
            if(temp->data == 0)
                temp->data = INT_MIN;
            temp = temp->next;
            count++;
        }
        if(temp==NULL)
            return 0;
        Node* te = head;
        int outloop = 0;
        while(te != temp){
            outloop++;
            te = te->next;
            if(te->data == INT_MIN)
                te->data = 0;
            else
                te->data = 0-(te->data);
        }
        while(te->data < 0){
            if(te->data == INT_MIN)
                te->data = 0;
            else
                te->data = 0-(te->data);
        }
        return (count-outloop);
    }
};
