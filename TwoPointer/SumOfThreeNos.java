
/*
[Note]
[Reference]: 
[Problem]: https://www.educative.io/courses/grokking-coding-interview-patterns-java/sum-of-three-values
[Pattern]: 2 pointers; + for loop, 2 pointers inside a for loop. 
[Tips]: duplicate is acceptable here. 
[Revision]: 0
[Confidence]: 30%
[Next]: Practice 
[Steps]: 
[Code]	
	
[/Code]
[Tags]: #3Sum_15
[/Note]
*/


/*
https://www.educative.io/courses/grokking-coding-interview-patterns-java/sum-of-three-values

Given an array of integers, nums, and an integer value, target, determine if there are any three integers in nums whose sum is equal to the target, that is, nums[i] + nums[j] + nums[k] == target. Return TRUE if three such integers exist in the array. Otherwise, return FALSE.
*/


// this is most optimum solution. Can look at striver's solution for more info.

import java.util.*;

public class SumOfThree{
   public static boolean findSumOfThree(int[] nums, int target) {
      
      // the 2 pointers can work on extreme, but the inside condition needs to change the calue of the 
      // 2 pointers according to some condition, for that we will find sum and then change the value 
      // of pointer, so we need to get the sum.
// #Note: Arrays.sort(nums); Here nums is int[] nums can sort a one dimentional array only
      Arrays.sort(nums);
      // loop outer this will be static for a while loop, this is easier

      // since we have to find sum of  nos, 2 nos movement can be handled by 2 pointers. for the third one
      // i need the one more for loop. 

      // the i value will be the basic outter loop, the 2 pointers will run from i+1 to n-1.
// #Note: primitive array's no of element can be found by .length; for int[] nums its nums.length
      int len = nums.length;

      // outer loop
      for(int i =0; i< len; i++){

    // 2 pointer approach.
    // initialize: left and right to i+1 and n-1.
    // do till:  while( left < right)
    // break and return: if SUM is found
    // change:  as per the SUM.
    
    // left and right initialized. 
         int left = i+1;
         int right = len-1;
         while( left < right){
            int sum = nums[i]+ nums[left]+ nums[right] ;
            if( sum == target){
               return true;
            }
            if( sum < target){left++;}
            else {right--;}
         
         }
      }
      // Replace this placeholder return statement with your code
      return false;
   }
}