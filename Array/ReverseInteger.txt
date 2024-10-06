/*
[Note]
[Reference]: 
[Problem]: https://leetcode.com/problems/reverse-integer/
[Pattern]: Trick
[Tips]: since 32 bit no, storage 2^31; do mod to find the last digit and add with * 10; divide the no. 
[Revision]: 0
[Confidence]: 10%
[Next]: Practice 
[Steps]: since 32 bit no, storage 2^31; do mod to find the last digit and add with * 10; divide the no. 
[Code]	
	
[/Code]
[Tags]: 
[/Note]
*/

/*
 * https://leetcode.com/problems/reverse-integer/
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the
 * value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 */

// own

class Solution {
  public int reverse(int x) {
    long result = 0;
    int num = x;
    if (num < 0) {
      num = Math.abs(num);
    }
    while (num > 0) {
      result = result * 10 + num % 10;
      num = num / 10;
    }
    if (x < 0) {
      result = result * -1;
    }
    if (result > Math.pow(2, 31) || result < Math.pow(-2, 31)) {
      result = 0;
    }
    return (int) result;
  }
}

// -----------------------
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
