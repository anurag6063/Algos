/*
# Algos
[Note]
[Reference]: 
[Problem]: https://leetcode.com/problems/maximum-depth-of-binary-tree/
[Pattern]: 
[Tips]: 
[Revision]: 0
[Confidence]: 10%
[Next]: Practice 
[Steps]: 
[Code]	
	
[/Code]
[Tags]: 
[Intution]
- this is divide and conqure algo. 
- its a recursive call way of binary searcg
- since it's a recursive call i need to have a seperate function that supports the recursion. 
- and since the recursive function has return type, so the return has to be made for each self call. 
- base case is left should not cross over the right. 
- primary check is that the nums should not be null. 
- three conditions needs to be checked, 
    - when mid is found,
    - when target is left of mid; set right as mid -1
    - when taget is right of mid, set left as mid +1
- remember since i alreay checked mid always set next left or right as mid + 1 or -1. 


[/Intution]
[QuestionNote]

[QuestionNote]
[/Note]
*/

public class binarySearchRecursion{
    public static int binarySearchRecursion (int []nums, int target) {
        
        // Replace this placeholder return statement with your code
        return findIndexOfTarget(nums, target, 0, nums.length -1);
    }

    private static int findIndexOfTarget(int[] nums, int target, int left, int right){

        // bc
        if(left > right){
            return -1;
        }
        // ops
        int mid = left + (right-left)/2;
        if(nums[mid] == target){
            return mid;
        }
// self call
        if(target < nums[mid]){
            return findIndexOfTarget(nums, target, left, mid-1);
        }else{
            return findIndexOfTarget(nums, target, mid+1, right );
        }

    }

    private static int binarySearchIteration(int[] nums, int target){
        int left = 0;
        int right = nums.length -1;
        while(left <= right){
            int mid = left + ((right - left)/2);
            if(nums[mid] == target){
                return mid;
            }
            else if (target < nums[mid]){
                right = mid-1;
            }else{
                left = mid +1;
            }
        }

        return -1;
    }

    public static void main(String[] args){
        int[] nums = {-1, 1,3,5,7,8,9};
        int target = -1;
        int taregtIndexRecur = binarySearchRecursion(nums, target);
        System.out.println(taregtIndexRecur);

        int taregtIndexIter = binarySearchIteration(nums, target);
        System.out.println(taregtIndexIter);
    }
}