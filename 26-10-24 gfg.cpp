class Solution {
  public:
    int count(struct Node* head, int key) {
        int cnt=0;
        auto it=head;
        while(it!=NULL)
        {
            if(it->data==key)cnt++;
            it=it->next;
        }
        return cnt;
    }
};
