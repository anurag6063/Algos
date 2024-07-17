
"""
/*
# Algos
[Note]
[Reference]: https://leetcode.com/problems/longest-consecutive-sequence/solutions/5395084/beginner-friendly-java-solution-beats-92-86/
[Problem]: https://leetcode.com/problems/longest-consecutive-sequence/description/
[Pattern]: Sort and Trick. 
[Tips]: We careful about skipping when nums are same. 
[Revision]: 0
[Confidence]: 10%
[Next]: Practice 
[Steps]: 
[Code]	
	
[/Code]
[Tags]: Sort
[Intution]: 
"""
Had to initialize as 1 since i was starting from index 1. 
controlled count varaiable as per if logic. 
Kept hold of longest sequence using max count. 
"""
[/Intution]
[QuestionNote]: 
"""

"""
[QuestionNote]
[/Note]
*/
"""


class Solution {
    public int longestConsecutive(int[] nums) {
         // validate
        if(nums == null || nums.length == 0){
            return 0;
         }

         if(nums.length == 1){
            return 1;
         }
         
         // ans and initialize
         int ans = 1;
         int count = 1;   

         // sort
         Arrays.sort(nums);
         System.out.println("sums "+ Arrays.toString(nums));
         for(int i = 1 ; i < nums.length; i++){
            // when its same number skip it. 
            if(nums[i] - nums[i-1] == 0){
                continue;
            }
            // when difference if not not resent the count.
            if(nums[i] - nums[i-1] != 1){
                count = 1;
            }else{
                // else i need the count to increase
                count ++;
            }
            // i don't need the last max count so keep  max in ans.
            ans = Math.max(ans, count);
            System.out.println("ans "+ ans + "element "+ nums[i]);

         }
         
         return ans;
    }
}
