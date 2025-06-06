class Solution {
  public:
    Node* sortedMerge(Node* head1, Node* head2) {
        if(!head1) return head2;
        if(!head2) return head1;
        Node* temp;
        if(head1->data < head2->data){
            temp=head1;
            head1=head1->next;
        }
        else{
            temp=head2;
            head2=head2->next;
        }
        Node* newHead=temp;
        while(head1 and head2){
            if(head1->data < head2->data)
        {
            temp->next=head1;
            head1=head1->next;
        }
        else{
            temp->next=head2;
            head2=head2->next;
        }
        temp=temp->next;
        }
        
        if(!head1) temp->next=head2;
        if(!head2) temp->next=head1;
        return newHead;
    }
};
