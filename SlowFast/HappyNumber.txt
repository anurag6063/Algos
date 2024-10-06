/*
link: https://www.educative.io/courses/grokking-coding-interview-patterns-java/happy-number
Write an algorithm to determine if a number 
�
n
 is a happy number.

We use the following process to check if a given number is a happy number:

*/

import java.util.*;

public class Main{
    public static boolean isHappyNumber(int n) {

        
        // initialize slow and fast to the number itself.         
        int slow , fast ;
        slow = fast = n;

        // this do will initilize the value inside the while loop. can use this when i know it will 
        // at least go in one step.

        // this can't be done for other problems because i don't know if they will go one step ahead or not

        do{
            slow = sumOfSqrDigit(slow);
            fast = sumOfSqrDigit(sumOfSqrDigit(fast));
        } while( slow != fast );

        // this pattern surely has a loop. So when the loop closes the numbers need to be equal to one.
        // else it will never have.
        return ( slow == 1 );
    }

    private static int sumOfSqrDigit(int n){

        // tipical way to get out the digit. 
        // 1. find mod , that the digit. 
        // 2. then divide by 10 to decrease the value.
        // 3. keep doing till num is creater than 0 , since we use integer and when it goes below 0 
        // it will anyways store 0 so we can say when it's not equals to 0. 
        int sum = 0;
        while(n != 0){
            int x = n%10;
            sum += x*x;
            n = n/10;
        }

        return sum;
    }
}