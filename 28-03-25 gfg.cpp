class Solution {
  public:
    int activitySelection(vector<int> &start, vector<int> &end) {
        int n=start.size();
        vector<pair<int,int>>store;
        for(int i=0;i<n;i++){
            store.push_back({start[i],end[i]});
        }
        sort(store.begin(),store.end());
        int maxi=1;
        int activity=1;
        int s=-1,e=-1;
        for(int i=0;i<n;i++){
            int first=store[i].first,second=store[i].second;
            if(s==-1 && e==-1){
                s=first,e=second;
            } else if(first>e){
                activity++;
                maxi=max(maxi,activity);
                s=first,e=second;
            } else if(first<=e){
                s=max(s,first),e=min(e,second);
            }
        }
        return maxi;
    }
};
