class Solution {
  public:
    int binarySearchable(vector<int>& arr) {
        int n = arr.size();
        int count = 0;
        for(int i = 0; i < n; i++) {
            int target = arr[i];
            int l = 0, r = n - 1;
            bool found = false;
            while(l <= r) {
                int mid = l + (r - l) / 2;
                if(arr[mid] == target) {
                    found = true;
                    break;
                } else if(arr[mid] < target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            if(found) count++;
        }
        return count;
    }
};
