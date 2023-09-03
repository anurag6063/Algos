/**
 * https://leetcode.com/problems/valid-palindrome/
 * 
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.
 */

 /** it's 2 pointer solution.
  * 
  important part: 
   while(!Character.isLetterOrDigit(s.charAt(l)) && l<r ){
                l++;
    }
    
    while(!Character.isLetterOrDigit(s.charAt(r)) && l<r){
        r--;
    }
    */
class Solution {
    public boolean isPalindrome(String s) {

        if(s.isEmpty()){
            return true;
        }
        s = s.toLowerCase();
        int l = 0;
        int r = s.length() -1;
        System.out.println(r);
        while(l<r){

            while(!Character.isLetterOrDigit(s.charAt(l)) && l<r ){
                l++;
            }
            
             while(!Character.isLetterOrDigit(s.charAt(r)) && l<r){
                 r--;
             }
             
                if(s.charAt(l) != s.charAt(r))
                    return false;
            
             l = l+1;
             r = r-1;
        }

    return true;

    }
}