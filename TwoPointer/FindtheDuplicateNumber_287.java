


/*
[Note]
[Reference]: https://www.youtube.com/watch?v=_n5MR8IxR6c
[Problem]: https://leetcode.com/problems/find-the-duplicate-number
[Pattern]: 2 pointer with slow and fast in array
[Tips]: use a slow and fast and detect the cycle, now find the duplicate node by resetting the slow and moving both at same speed. 
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
    
     public int findDuplicate(int[] nums) {
     
         
         // / find the loop first
         // slow and fast
         int slow = 0;
         int fast = 0;
  // did not ceck the condition first since initally yhey both will be at some starting point       
         do{
             slow = nums[slow];
             fast = nums[nums[fast]];
         }while(slow != fast);
         
         
         // once we find the intersecion point. reset slow to 0 and move again this will find the fast
         slow = 0;
         
         while(slow != fast){
             slow = nums[slow];
             fast = nums[fast];
         }
         
         return slow;
         
     }
    
    // should have worked had the repeted no occur just once extra times.
    public int findDuplicate_JustTwice(int[] nums) {
        
        /*
        sort array
        now start from 1 and check if last no should not be same
        
        yes:[1,3,4,2,2]
        fins sum = 12
        max = 4 ; 10 
        sum = [n*(n+1)]/2 20/2 = 10 
        diff = 4 
        */
        int max = nums[0];
        int sum = 0;
        
        for(int i =0; i< nums.length; i++){
            sum += nums[i];
            max = Math.max(max, nums[i]);
        }
        
        int shouldBe = (max*(max+1))/2;
        System.out.println(shouldBe);
        return sum-shouldBe;
    }
}