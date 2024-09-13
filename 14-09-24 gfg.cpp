class Solution {
  public:
    void rearrange(vector<int> &arr) {
        queue<int> p, n;
        for(auto x: arr){
            if(x>=0)p.push(x);
            else n.push(x);
        }
        int i =0;
        while(p.size() && n.size()){
            if(i&1){arr[i++]=n.front(); n.pop();}
            else {arr[i++]=p.front(); p.pop();}
        }
        while(p.size()){
            arr[i++]=p.front(); p.pop();
        }
        while(n.size()){
            arr[i++]=n.front(); n.pop();
        }
    }
};
