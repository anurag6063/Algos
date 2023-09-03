
/**
 * https://leetcode.com/problems/contains-duplicate/
 * 
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinc
 */
import java.util.*;

class Solution {
    public boolean containsDuplicate(int[] nums) {


        Map<Integer,Integer> counter = new HashMap<>();
        if(nums.length <2){
            return false;
        }

        for(int i=0; i< nums.length; i++){
            if(counter.get(nums[i]) != null){
                return true;
            }
            counter.put(nums[i], 1);
        }

        return false;


    }
}
        // int[] unique = new int[nums.length];
        // Arrays.fill(unique, Integer.MAX_VALUE);
        // int index = 0;
        // if(nums.length <2){
        //     return false;
        // }
        // for(int i=0; i<nums.length; i++){
           
        //     for(int j=0;j<unique.length; j++){
        //         //  System.out.println( nums[i] +" : "+ unique[j]);
        //         if(nums[i] == unique[j]){
        //             return true;
                    
        //         }
        //         // unique[index] = nums[i];
        //         if(j == unique.length-1){
        //             unique[index] = nums[i];
        //             index++;
        //         }
        //     }

        // }
        //   return false;
    //}
  
//}