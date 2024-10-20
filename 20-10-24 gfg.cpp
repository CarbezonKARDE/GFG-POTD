struct CompareDLLNode {
    bool operator()(DLLNode* a, DLLNode* b) {
        return a->data > b->data;
    }
};
class Solution {
  public:
    
    DLLNode *sortAKSortedDLL(DLLNode *head, int k) {
        if (head == NULL) return NULL;
        DLLNode *new_head=NULL;
        DLLNode *curr_new=NULL;
        priority_queue<DLLNode*, vector<DLLNode*>, CompareDLLNode> pq;
        for(int i=0;head!=NULL and i<=k;i++){
            pq.push(head);
            head=head->next;
        }
        while(!pq.empty()){
            if(new_head==NULL){
                new_head=pq.top();
                curr_new=new_head;
                new_head->prev=NULL;
            }
            else{
                curr_new->next=pq.top();
                pq.top()->prev=curr_new;
                curr_new=pq.top();
            }
            pq.pop();
            if(head!=NULL){
                pq.push(head);
                head=head->next;
            }
        }
        if (curr_new != NULL) {
            curr_new->next = NULL; 
        }
        return new_head;
    }
 
};
