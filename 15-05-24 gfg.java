class  Disjointset{
        List<Integer> parent=new ArrayList<>();
        List<Integer> rank=new ArrayList<>();
        List<Integer> size=new ArrayList<>();
        public Disjointset(int n){
            for(int i=0;i<=n;i++){
                parent.add(i);
                rank.add(0);
                size.add(1);
            }
        }
        public int findUPar(int node){
            if(node==parent.get(node)){
                return node;
            }
            int ulp=findUPar(parent.get(node));
            parent.set(node,ulp);
            return parent.get(node);
        }
        public  void unionbyRank(int u,int v){
            int par_u=findUPar(u);
            int par_v=findUPar(v);
            if(rank.get(par_v)<rank.get(par_u)){
                parent.set(par_v,par_u);
            }
            else   if(rank.get(par_v)>rank.get(par_u)){
                parent.set(par_v,par_u);
            }
            else{
                parent.set(par_v,par_u);
                int rankU=rank.get(u);
                rank.set(par_u,rankU+1);
            }
        }
        public  void unionbysize(int u,int v){
            int par_u=findUPar(u);
            int par_v=findUPar(v);
            if(size.get(par_v) <size.get(par_u)){
                parent.set(par_v, par_u);
                size.set(par_u, size.get(par_v) + size.get(par_u));
            }
            else{
                parent.set(par_u,par_v);
                size.set(par_v,size.get(par_v)+size.get(par_v));
            }
        }
    }
class Solution {
    static ArrayList<ArrayList<String>> accountsMerge(
        ArrayList<ArrayList<String>> accounts) {
            Disjointset ds=new Disjointset(accounts.size());
            HashMap<String,Integer> hm=new HashMap<>();
            for(int i=0;i<accounts.size();i++){
                for(int j=1;j<accounts.get(i).size();j++){
                    String mail=accounts.get(i).get(j);
                    if(hm.containsKey(mail)){
                       ds.unionbysize(hm.get(mail),i); 
                    }
                    else{
                        hm.put(mail,i);
                    }
                }
            }
        ArrayList<String>[] ans=new ArrayList[accounts.size()];
        
         for(int i=0;i<accounts.size();i++){
              ans[i]=new ArrayList<String>();
            }
       for(Map.Entry<String,Integer> ent:hm.entrySet()){
           
           int val=ent.getValue();
           String key=ent.getKey();
           int par= ds.findUPar(val);
           ans[par].add(key);
       }
       ArrayList<ArrayList<String>> Fans=new ArrayList<>();
       for(int i=0;i<accounts.size();i++){
           if(ans[i].size()==0) continue;
           Collections.sort(ans[i]);
           ArrayList<String> temp=new ArrayList<>();
           temp.add(accounts.get(i).get(0));
           for(String it:ans[i]){
               temp.add(it);
           }
           Fans.add(temp);
       }
       return Fans;
    }
}
