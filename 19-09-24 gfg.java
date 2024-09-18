class Solution {
    String reverseWords(String S){
       int n=S.length();
       String a="";
       int count=0;
       for(int i=n-1;i>=0;i--){
           if(S.charAt(i)=='.'){
               a+=S.substring(i+1,i+1+count);
               a+='.';
               count=0;
           }
           else{
               count++;
           }
       }for(int i=0;i<S.length() && S.charAt(i)!='.';i++){
           a+=S.charAt(i);
       }
       return a;    
    }
}
