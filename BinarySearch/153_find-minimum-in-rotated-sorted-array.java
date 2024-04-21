/*
# Algos
[Note]
[Reference]: 
[Problem]: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
[Pattern]: BS, trick
[Tips]: find flux point, ex the point where value is less than prev but creater than next, thats answer, else if val at right < num[mid] move to right else left
[Revision]: 0
[Confidence]: 10%
[Next]: Understand
[Steps]: 
[Code]	
	
[/Code]
[Tags]: 
[/Note]

*/
class Solution2 {
    public int findMin(int[] nums) {

        // containrs
        int size = nums.length;
        int l = 0, r = size-1;
        
        // process
        while(l < r){

            int mid = (r+l)/2;
            System.out.printf("mid %d, num %d \n",  mid, nums[mid]);
            // flux point
            if(nums[mid] < nums[mid+1]){
                return nums[mid];
            }
            else if(nums[mid] > nums[r]){
                l = mid+1;
            }else{
                r = mid;
            }
        }

        return nums[0];
        
        
    }
}
class Solution {
    public int findMin(int[] nums) {

        // containers
        int size = nums.length;
        int l = 0, r = size-1;
        
        // process
        while(l <= r){
            int mid = (r + l) / 2;
            
            // flux point
            if( nums[(mid-1+size) % size] > nums[mid] && nums[mid] < nums[(mid+1) % size] ){
                return nums[mid];
            }
            else if(nums[mid] > nums[r]){
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }
        }

        return nums[0];
    }
}
