class Solution {
    long floorSqrt(long n) 
    {
        long s = 0;
        long e = n;
        
        while(s <= e)
        {
            long mid = s + (e-s)/2;
            
            if(mid * mid == n)
            {
                return mid;
            }
            else if(mid * mid > n)
            {
                e = mid - 1;
            }
            else
            {
                s = mid+1;
            }
        }
        return e;
    }
}
