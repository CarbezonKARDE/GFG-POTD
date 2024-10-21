class Solution {
     public static int countgroup(int arr[]) {

      int n=arr.length;
     int totalXOR=0;
      for(int i=0;i<arr.length;i++)
      {
          totalXOR=totalXOR^arr[i];
      }
      if(totalXOR!=0)
      {
          return 0;
      }
      else
      {
            return (int) (((Math.pow(2,(arr.length-1)))-1) % 1000000007);
      }
       
    }
}
