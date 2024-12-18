class Solution {
  public:
    int findPages(vector<int> &arr, int k) {
        int n = arr.size();
        int s = arr[0],  e = 0, mid;
        if(k>n){
            return -1;
        }
        for(int i = 0; i<n; i++){
            e = e + arr[i];
            
            if(s < arr[i]){
                s = arr[i];
            }
        }
        int ans ;
        while(s<=e){
            mid = s + (e-s)/2;
            int count = 1;
            int sum = 0;
            for(int i = 0; i<n; i++){
                
                sum+=arr[i];
                if(sum > mid){
                    count++;
                    sum = arr[i];
                }
            }
            if(count<=k){
                ans = mid;
                e = mid-1;
            }else{
                s = mid + 1;
            }
        }
        return ans;
    }
};
