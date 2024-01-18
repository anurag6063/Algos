
/*
[Note]
[Reference]: https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/solutions/27976/3-6-easy-lines-c-java-python-ruby
[Problem]: https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/?envType=list&envId=ecumdrrd
[Pattern]: Trick, Copy when needed. 
[Tips]: Simple trick
[Revision]: 0
[Confidence]: 10%
[Next]: Practice 
[Steps]: 
[Code]	
	
[/Code]
[Tags]: 
[/Note]
*/


class Solution {
    public int removeDuplicates(int[] nums) {
        /**
        Note:
        - need only 2 occ
        Brute: store in a hasmap and then again read from there if till count is 2
        
        - 2 pointer, same direction
        when will left increase -> till 

         */ 

         int i =0;
         for(int n: nums){
            if(i < 2 || n > nums[i-2]) // the first n<2 is saving the error on i-2
               nums[i++] = n;
         }

        //  Arrays.stream(nums).forEach(System.out::println);

         return i;
    }

    
}