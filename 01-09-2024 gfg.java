class Solution {
    public int maxPathSum(List<Integer> arr1, List<Integer> arr2) {
        HashMap<Integer, Integer> map= new HashMap<>();
        int l1= arr1.size();
        int l2 = arr2.size();
        int i, j, sum1, sum2, result;
        i=j=sum1=sum2=result=0;
        while(i<l1 && j<l2){
            if(arr1.get(i)<arr2.get(j)){
                sum1+=arr1.get(i);
                i++;
            }
            else if(arr1.get(i)>arr2.get(j)){
                sum2+=arr2.get(j);
                j++;
            }
            else{
                result = Math.max(sum1, sum2) + arr1.get(i);
                sum1=result;
                sum2=result;
                i++;
                j++;
            }
        }
        while(i<l1){
            sum1+=arr1.get(i);
            i++;
        }
        while(j<l2){
            sum2+=arr2.get(j);
            j++;
        }
        result = Math.max(sum1, sum2);
        
        return result;
    }
}
