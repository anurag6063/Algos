/*
 * https://leetcode.com/problems/reverse-integer/
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the
 * value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 */

 class Solution {
    public int reverse(int x) {   
      int y = x;
      long num = 0;
      if(x < 0){
        x = Math.abs(x);  
       }

       while(x>0){
         
        // int digit = x % 10;
           num = num*10 + x%10;
//         System.out.println(num + " num "+ digit + " digit" + x + " x");
           x = x/10;
       }

    if( num < Math.pow(-2,31) || num > Math.pow(2,31) ){
        System.out.println(num);
        return 0;
      }

      if(y<0){
        return (int) num*(-1);
      }
      
      System.out.println(num);
      
      if( num < Math.pow(-2,31) || num > Math.pow(2,31) ){
        System.out.println(num);
        return 0;
      } 
      else{
       return(int) num;}
    }
}