/*
# Algos
[Note]
[Reference]: https://leetcode.com/problems/summary-ranges/solutions/5127208/java-runtime-0ms-beats-100-00-of-users-with-java
[Problem]: https://leetcode.com/problems/summary-ranges/description/
[Pattern]: Interval, Inner Loop to move forward
[Tips]: Try to think how can be done by hand, implement
[Revision]: 0
[Confidence]: 10%
[Next]: Practice 
[Steps]: 
[Code]	
	
[/Code]
[Tags]: 
[Intution]: 
"""
If i had to do same by hand. I would check the emelent and see if it's next one is consecutive or not.
If yes then that i do num + arrow and check for the ending.

Else i would simply put the start as an answer. 

While moving forward remember 2 things.
Do not cross i = nums.length -1 , this is the last index, so i need to stop before this. i < nums.length - 1 
to move index ahead while trying to find the end. 
use a inner while loop 

"""
[/Intution]
[QuestionNote]: 
"""

"""
[QuestionNote]
[/Note]
*/

class Solution {
    public List<String> summaryRanges(int[] nums) {
        
        List<String> ans = new ArrayList<>();
        StringBuffer element = new StringBuffer();

        for(int i=0; i<nums.length; i++){
            if(i < nums.length-1 && nums[i] == nums[i+1]-1){
                // if consecutive
                element.append(nums[i]).append("->");
                while(i < nums.length-1 && nums[i] == nums[i+1]-1){
                    i++;
                }
                element.append(nums[i]);
                ans.add(element.toString());
                element.setLength(0);
            }else{
                ans.add(nums[i]+"");
            }
        }

        return ans;
    }
}
