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
        return (x==check || x==check/10);
}
}