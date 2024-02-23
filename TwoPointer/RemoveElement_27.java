
/*
[Note]
[Reference]: 
[Problem]: https://leetcode.com/problems/remove-element/?envType=list&envId=ecumdrrd
[Pattern]: 2 pointers, same direction (for loop)
[Tips]: use left as index var, and right in for loop; same 
[Revision]: 1
[Confidence]: 50%
[Next]: Practice 
[Steps]: replace the value when nums[i] != val; care when it does not matches. 
[Code]	
	if(nums[i] != val){
	 nums[index] = nums[i];
	 index++;
 }
[/Code]
[Tags]: 
[/Note]
*/

/**
 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
 * Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2,_,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 2.
It does not matter what you leave beyond the returned k (hence they are underscores).
 */

class Solution {
        
    public int removeElement(int[] nums, int val) {
         
         int index = 0;
// #Note: I use a for loop when its 2 pointers in starting from origin and going right. (same direction). One pointer is held by for loop, which moves at constanct speed. the other is help by a variable, which is declared earlier and moved when needed.  I will surely use a IF clause in the for loop to check when to move the left behind pointer, do the operation and move the left pointer.
         for(int i=0; i< nums.length; i++){
             if(nums[i] != val){
                 nums[index] = nums[i];
                 index++;
             }
             
         }
      
         return index;
     }
	   

     
/*   public int removeElement(int[] nums, int val) {
        int count =0;
        for(int i=0; i< nums.length ; i++){
            System.out.println(val +": "+ nums[i]);
            if(val == nums[i]){
                nums[i]= 100;
                count++;
            }
            // System.out.println(Arrays.toString(nums));
        }
        Arrays.sort(nums);
        // System.out.println("final "+Arrays.toString(nums));
        return nums.length-count;
    }
/*
   /*  public int removeElement(int[] nums, int val) {
        int count = 0;
        int start = end = 0;
        int temp = 0;
        for(int i=0; i< nums.length ; i++){
            System.out.println(val +": "+ nums[i]);
            if(val == nums[i]){
                if(nums[start] != val) start = i;
                end = i;
                count++;
            }
            // System.out.println(Arrays.toString(nums));
        }
        Arrays.sort(nums);
        // System.out.println("final "+Arrays.toString(nums));
        return nums.length-count;
    }
    */


}

