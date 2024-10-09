class Solution {
  public:
    int maxDistance(vector<int> &arr) {
       int dist=0;
       map<int,int>lastind;
       for(int i=arr.size()-1;i>=0;i--){
           if(lastind.find(arr[i])!=lastind.end()){
               dist=max(dist,lastind[arr[i]]-i);
           }
           else{
               lastind[arr[i]]=i;
           }
       }
       return dist;
    }
};
