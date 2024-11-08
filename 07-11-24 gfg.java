class Solution {
    public List<Integer> findSplit(int[] arr) {
        List<Integer> ls = new ArrayList<>();
        int totalSum = Arrays.stream(arr).sum();
        int firstIndex = -1;
        int secondIndex = -1;
        if(totalSum%3 != 0){
            ls.add(-1);
            ls.add(-1);
            return ls;
        }
        int prefSum = 0;
        for(int i=0; i<arr.length; i++){
            prefSum += arr[i];
            if(prefSum == totalSum/3 && firstIndex == -1){
                firstIndex = i;
                ls.add(firstIndex);
                prefSum = 0;
            } else {
                if(secondIndex == -1 && prefSum == totalSum/3){
                    secondIndex = i;
                    ls.add(secondIndex);
                    return ls;
                }
            }
        }
        return Arrays.asList(-1, -1);
    }
}
