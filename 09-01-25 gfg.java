class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        int i = 0;
        int j = 0;
        int sum = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while(i<arr.length && j<arr.length){
            sum+=arr[j];
            if(sum==target){
                list.add(i+1);
                list.add(j+1);
                break;
            }
            if(sum>target){
                while(sum>target){
                    sum-=arr[i];
                    i++;
                }
            }
            if(sum==target){
                list.add(i+1);
                list.add(j+1);
                break;
            }
            j++;
        }
        if(list.size()==0){
            list.add(-1);
            return list;
        }
        return list;
    }
}
