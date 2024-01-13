/**
 * https://leetcode.com/problems/palindrome-number/
 * Given an integer x, return true if x is a 
palindrome
, and false otherwise.
 */


 // initialize: initialize of return not needed since it's boolean
 // pallindrom number. 
 // sol: find reverse number. 
 // for this initialize a variable thats 0.
 // while given no is created that the no that i am forming. 

 // find the last digit and multiply by 10.
 // reduce the no by 10

class Solution {
  public boolean isPalindrome(int x) {
  if(x<0 || x!=0 && x%10 ==0 ) return false;
        int check=0;
        while(x>check){
            System.out.println(check);
            check = check*10 + x%10;
            System.out.println("post "+check);
            x/=10;
            System.out.println(x);
        }

        // didn't underatand
   // ? maybe becuse the x gets divided by 10 fianlly so to match that we have check also /10.
        return (x==check || x==check/10);
}
}


// -------------------------
// own solution
// first basic check
// reverse whole no and then check.
// optimization, check in b/w

class Solution {
  public boolean isPalindrome(int x) {

      if( x < 0){
          return false;
      }
      if(x/10 == 0 || x<0){
          return true;
      }
    int num = x;
    int rev = 0;

      while(x>0){
         rev = x % 10  + rev*10;
         x = x/10;
      }
      
    if(rev == num){
        return true;
    }
   
    return false;
   
  }
}
