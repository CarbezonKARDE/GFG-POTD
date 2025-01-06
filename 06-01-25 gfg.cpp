class Solution {
  public:
    vector<int> sumClosest(vector<int>& arr, int target) {
        int i=0,j=arr.size()-1; 
        vector<int>ans; 
        int diff=INT_MAX; 
        sort(arr.begin(),arr.end());
        while(i<j){
            int sum=arr[i]+arr[j];
             if(abs(target-sum)<diff){
                ans={arr[i],arr[j]}; 
                diff=abs(target-sum);
            }
            if(sum==target){
                i++; 
                j--; 
            }else if(sum<=target ){
                i++; 
            }else{
                j--; 
            }
        }
        return ans;
    }
};
