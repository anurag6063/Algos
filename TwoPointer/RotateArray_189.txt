


/*
[Note]
[Reference]: https://leetcode.com/problems/rotate-array/solutions/1730142/java-c-python-a-very-very-well-detailed-explanation
[Problem]: https://leetcode.com/problems/rotate-array/
[Pattern]: NA
[Tips]: Keep the last one asise, Move no from back in array. 
[Revision]: 0
[Confidence]: 10%
[Next]: Need two pointer solution 
[Steps]:  Brute Force: have 2 loops, outer goes k times inner to move the values (len) times, store n in var , more array and store the lst value back. 
[Code]	
	
[/Code]
[Tags]: 
[/Note]
*/

class Solution {
    public void rotate(int[] nums, int k) {
      
        /*  [1,2,3,4,5,6,7], k = 3
        
        [5,6,7,  1,2,3,4]
        k = len/k
        brute force:
        for(i=1; i<k; i++)
        {
            arr[i] = arr[i-1];
        
        }
        
        [1,1,2,3,4,5,6] ->  
        */
        
        rotateBrute(nums,k);
    }
//     public void rotate2Poiter(int[] nums, int k) {
//         k = k % nums.length;
//         int left = 0;
//         int right = nums.length-1;
//         while(l < k){
//             int last = nums[nums.length-1];
            
//         }
//     }
    
    public void rotateBrute(int[] nums, int k) {
        
        for(int j = 0; j < k; j++){
            int last = nums[nums.length-1];
            for(int i = nums.length-1 ; i > 0 ; i--){
                nums[i] = nums[i-1];    
            }  
            nums[0] = last;
        }
        
    }
}