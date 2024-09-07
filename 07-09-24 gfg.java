class Solution {
    long findNth(long n) {
        long ans=0, place=1;
        while(n>0){
            long rem = n%9;
            ans += rem * place;
            n /= 9;
            place *= 10;
        }
        return ans;
    }
}
