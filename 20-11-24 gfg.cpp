class Solution {
  public:
    vector<int> findMajority(vector<int>& arr) {
        int ele1, ele2, cnt1=0, cnt2=0;
        for(auto it:arr){
            if(cnt1==0 && it!=ele2){
                cnt1=1;
                ele1=it;
            }
            else if(cnt2==0 && it!=ele1){
                cnt2=1;
                ele2=it;
            }
            else if(it==ele1)
                cnt1++;
            else if(it==ele2)
                cnt2++;
            else{
                cnt1--;
                cnt2--;
            }
        }
        cnt1=0, cnt2=0;
        for(auto it:arr){
            if(it==ele1)
                cnt1++;
            if(it==ele2)
                cnt2++;
        }
        vector<int> res;
        if(cnt1>arr.size()/3)
            res.push_back(ele1);
        if(cnt2>arr.size()/3)
            res.push_back(ele2);
        sort(res.begin(),res.end());
        return res;
    }
};
