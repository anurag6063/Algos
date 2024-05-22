public class BinarySearch{
    public static int binarySearch (int []nums, int target) {
        
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

    public static void main(String[] args){
        int[] nums = {1,3,5,7,8,9};
        int target = 9;
        int taregtIndex = binarySearch(nums, target);
        System.out.println(taregtIndex);
    }
}