/**
 * https://www.educative.io/courses/grokking-coding-interview-patterns-java/valid-palindrome-ii
 * 
 * Valid Palindrome II
 * Write a function that takes a string as input and checks whether it can be a valid palindrome by removing at most one character from it.
 * 
 */

import java.util.*;

public class Main{
    public static boolean isPalindrome(String s) {



    // 2 pointer approach.
    // initialize: left and right to 0 and len-1.
    // do till:  while( left < right)
    // break and return if: if letters are diff / we need to start and check pallindrom again with 
                            // a) left+1 and right or 
                            // else left and right-1

                            // if both of them say it's valid then only it's valid else not.
    // Do: NA
    // change: left ++ and right --;


// this code helped to avaid keeping track of no of anomaly.
// drawback, repeted code. 


        int left = 0;
        int right = s.length()-1;

        while(left < right){
            if(s.charAt(left) != s.charAt(right)){

                //  System.out.println("found a mismathch "+ left  + 
                //  s.charAt(left) +" : "+ right + s.charAt(right) );

                return validPallindrom(left, right-1, s) || validPallindrom(left+1, right, s);
              }

                left++;
                right--;
        }
        return true;
    }

    public static boolean validPallindrom(int left, int right, String s){

         while(left < right){
            if(s.charAt(left) == s.charAt(right)){                 
            }else{
                return false;
            }
              left++;
              right--;
         }
         return true;
}
}