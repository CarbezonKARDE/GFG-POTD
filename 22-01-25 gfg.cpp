class Solution {
  public:
    Node *rev(Node *head){
        Node *prev=NULL,*curr=head,*next=NULL;
        while(curr!=NULL){
            next=curr->next;
            curr->next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    Node *trim(Node *head){
        while(head->next!=NULL&&head->data==0){
            head=head->next;
        }
        return head;
    }
    Node* addTwoLists(Node* num1, Node* num2) {
        num1=trim(num1);
        num2=trim(num2);
        num1=rev(num1);
        num2=rev(num2);
        Node *res=NULL,*curr=NULL;
        int c=0;
        while(num1!=NULL||num2!=NULL||c!=0){
            int sum=c;
            if(num1!=NULL){
                sum+=num1->data;
                num1=num1->next;
            }
            if(num2!=NULL){
                sum+=num2->data;
                num2=num2->next;
            }
            Node *temp=new Node(sum%10);
            c=sum/10;
            if(res==NULL){
                res=temp;
                curr=temp;
            }else{
                curr->next=temp;
                curr=curr->next;
            }
        }
        return rev(res);
    }
};
