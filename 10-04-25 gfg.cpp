class Solution {
  public:
  vector<int>par,size;
    int minCost(vector<vector<int>>& houses) {
        int n=houses.size();
        map<int,vector<vector<int>>>mp;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int dis=abs(houses[j][0]-houses[i][0])+abs(houses[j][1]-houses[i][1]);
                mp[dis].push_back({i,j});
            }
        }
        par=vector<int>(n);
        size=vector<int>(n);
        build(n);
        int count=n-1;
        int ans=0;
        for(auto it:mp){
            for(auto it1:it.second){
                if(findpar(it1[0])!=findpar(it1[1])){
                    ans+=it.first;
                    unions(it1[0],it1[1]);
                    count--;
                }
                if(count==0) break;
            }
            if(count==0) break;
        }
        return ans;
    }
        void build(int n){
        for(int i=0;i<n;i++) par[i]=i,size[i]=1;
    }
    int findpar(int a){
        return par[a]=(par[a]!=a?findpar(par[a]):a);
    }
    void unions(int a,int b){
        a=findpar(a),b=findpar(b);
        if(size[a]<size[b]) swap(a,b);
        size[a]+=size[b];
        par[b]=a;
    }
};
