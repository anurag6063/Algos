/**https://leetcode.com/problems/two-sum/
 * 
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
 */

class Solution {

public int[] twoSum(int[] nums, int target) {    
      
    Map<Integer,Integer> data = new HashMap<>();
    int[] ans = new int[2];

    for(int i=0; i< nums.length ; i++){

    // data.forEach( (k,v) -> System.out.print(k + ":" + v));
    // System.out.println("next "+ i);    
    // System.out.println(Arrays.toString(a));

        if(data.containsKey(target - nums[i])){
            // if(( target - nums[i]) - data.getOrDefault(target - nums[i], 0) == 0 ){
                ans[0]= i;
                ans[1] = data.get(target - nums[i]);
                return ans;            
        }
        data.put(nums[i], i);
      }

      return null;
}
}

// target = 9
// i have a no 2 ; 7
// other no can be 9-2 = 7; 7-9 = 2

// check for 7
  // found return
// put 2 in map ; 7
// repete