class Solution {
  public:
    Node* reverse(Node* head) {
      Node * prev=NULL;
      
      Node *curr=head;
      Node *temp=curr->next;
      while(temp->next!=NULL){
          curr->next=prev;
          prev=curr;
         
          curr=temp;
          temp=temp->next;
      }
      temp->next=curr;
      curr->next=prev;
      return curr;
      
    }
    Node* deleteNode(Node* head, int key) {
        Node *temp=head->next;
        Node *ptr=head;
        
        if(head->data==key){
            while(ptr->next!=head)
             ptr=ptr->next;
             ptr->next=temp;
             delete head;
             return temp;
        }
        else{
            while(temp!=head&&temp->data!=key){
                ptr=temp;
                temp=temp->next;
                
            }
            if(temp->data==key){
                ptr->next=temp->next;
                delete temp;
            }
            return head;
        }
    }
};
