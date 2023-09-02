/*
link: https://www.educative.io/courses/grokking-coding-interview-patterns-java/valid-palindrome
Write a function that takes a string, s, as an input and determines whether or not it is a palindrome.

*/

import java.util.*;

public class Main{
    public static boolean isPalindrome(String s) {
       



       // initailize 2 pointers one in start and one at end.
       // this strategy in special case reduces two loop to just one.


    // 2 pointer approach.
    // initialize: left and right to 0 and len-1.
    // do till:  while( left < right)
    // break and return if: chars don;t match
    // change: if they match. increase left and decrease right.


        int left = 0 ;
        int right = s.length()-1;
        // Replace this placeholder return statement with your code




       //  while(left<right) when we have pointers at 2 extreme ends, this statememt works. 
        while(left<right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}