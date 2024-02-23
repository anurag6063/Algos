


/*
[Note]
[Reference]: https://leetcode.com/problems/move-zeroes/solutions/2685367/js-es6-two-pointers-93-with-explanation
[Problem]: https://leetcode.com/problems/move-zeroes/
[Pattern]: 2 pointers same direction;
[Tips]: 2 pointers ; swap when right != 0; swap when needed with if and increment the left counter, else always increase right pointer.
[Revision]: 0
[Confidence]: 10%
[Next]: Practice 
[Steps]: use 2 pointers; right to traverse whole length; if nums[right] != 0 swap and update left and right
[Code]	
	
[/Code]
[Tags]: 
[/Note]
*/
/*
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
*/


class Solution {
    
     public void moveZeroes(int[] nums) {
         
         int left = 0;
         int right = 0;
         
         while(right < nums.length){
             System.out.println("a");
             if(nums[right] != 0){
                 System.out.println("swap");
                 // swap
                 int temp = nums[left];
                 nums[left] = nums[right];
                 nums[right] = temp;
                 
                 left++;
             }
             right++;
         }
         
     }
    
    
     public void moveZeroesIncorrect(int[] nums) {
      /*
      
      nums = [0,1,0,3,12]
      
      
      */   
      int left = 0;
      int right = nums.length -1;
      // this will not maintain the order   
      while(left < right){
          if(nums[left]== 0){
              // swap 
              int temp = nums[right];
              nums[right] = nums[left];
              nums[left] = temp;
              
              // int temp = nums[left];
              //   nums[left] = nums[right];
              //   nums[right] = temp;
          }
          left ++;
          right ++;
      }
         
     }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void moveZeroes2(int[] nums) {
    
    int left = 0, right = 0;
    if(nums.length == 1) return;

    while(right < nums.length ){
    //    System.out.println(left +" "+ right );
        if(nums[right] != 0){
            nums = swap(left, right, nums);
            left++;
        }
       
    right ++;
       
   }
    
}

    private int[] swap(int left, int right, int[] nums){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;

        return nums; 
    }

}