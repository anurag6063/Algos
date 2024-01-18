/*
[Note]
[Reference]: 
[Problem]: 
[Pattern]: 2 pointers; opposite direction; 
[Tips]: 2 poniters; special initali while loop to skip invalid chars, compare only when needed. !Character.isLetterOrDigit(s.charAt(r)) && l<r)
[Revision]: 1
[Confidence]: 10%
[Next]: Practice 
[Steps]: 2 pointer; left++ till char or digit is found, right -- till char or digit is found, compare the char (now the chars ara valid and can be compared) 
[Code]	
	!Character.isLetterOrDigit(s.charAt(l)) && l<r )
[/Code]
[Tags]: #2Pointers
[/Note]
*/
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

         // skipping non character/digit value. left++ till it's a char /digit and left is less than right. 
            while(!Character.isLetterOrDigit(s.charAt(l)) && l<r ){
                l++;
            }
            // same for right. 
             while(!Character.isLetterOrDigit(s.charAt(r)) && l<r){
                 r--;
             }

         // this is the main function that we have. But since we need to skip all non valid characters. before this we will skip them. 
                if(s.charAt(l) != s.charAt(r))
                    return false;
            
             l = l+1;
             r = r-1;
        }

    return true;

    }
}
