/*
[Note]
[Reference]: 
[Problem]: https://leetcode.com/problems/contains-duplicate/
[Pattern]: HashMap
[Tips]: Use a hashMap for quick lookup, with brute approach i look for duplicate foreward, with HashMap, i am looking for the duplicate backward, that too in constant time since i am using a hashMap.
[Revision]: 1
[Confidence]: 90%
[Next]: Practice 
[Steps]: Loop, check in HMap if present return false; else finally out return true;
[Code]	
	
[/Code]
[/Note]
*/
/**
 * https://leetcode.com/problems/contains-duplicate/
 * <p>
 * Given an integer array nums, return true if any value appears at least twice in the array, and
 * return false if every element is distinct
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// the basics brute force idea. 
// here i am checking each i element with i+1 to n element. 


class ContainsDuplicateNumber_BF {

    public boolean containsDuplicate(int[] nums) {
    boolean result = false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
              if (nums[i] == nums[j]) {
                result = true;
                break;
              }
            }
    }
    return result;
    }
}

// the bottleneck is that the second loop seems the same element that the first element sees. So i need to find a better way
// to see and check the elements.

class ContainsDuplicateNumber_OP_Set {

    public boolean containsDuplicate(int[] nums) {
    boolean result = false;
    // instead of second loop we are using a HashSet.
    Set<Integer> numsHs = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            // the if condition changed
            if (numsHs.contains(nums[i])) {
            return true;
            }
            numsHs.add(nums[i]);
    }
    return result;
    }
}

// ------------------------------------------------
// below we still have 2 valid answers. 
// but Set is better than Map. 
// in second below ans, the array will be too huge. 
class ContainsDuplicateNumber_Map {

    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        if (nums.length < 2) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            if (counter.get(nums[i]) != null) {
                return true;
            }
            counter.put(nums[i], 1);
        }
        return false;
    }
}

class ContainsDuplicateNumber_Array {
    public boolean containsDuplicate(int[] nums) {
        int[] unique = new int[nums.length];
        Arrays.fill(unique, Integer.MAX_VALUE); // #Memorize
        int index = 0;
        if (nums.length < 2) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < unique.length; j++) {
                //  System.out.println( nums[i] +" : "+ unique[j]);
                if (nums[i] == unique[j]) {
                    return true;
                }
                // unique[index] = nums[i];
                if (j == unique.length - 1) {
                    unique[index] = nums[i];
                    index++;
                }
            }
        }
        return false;
    }
}
