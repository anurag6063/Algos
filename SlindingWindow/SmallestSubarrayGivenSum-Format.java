/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/submissions/
 */

class SmallestSubarrayGivenSum {
    public int minSubArrayLen(int target, int[] nums) {
        int length = Integer.MAX_VALUE;
        int left = 0;
        int sum =0;
        for(int right =0; right < nums.length; right++ ){
            sum = sum + nums[right];
            System.out.println(sum);
            while(sum >= target){
                System.out.println("sum is greater" + sum);
                length = Math.min(length, right-left+1);
                sum = sum - nums[left];
                left++;
                System.out.println("end: sum is greater" + sum+ " "+ length);
            }
        }
        if(length == Integer.MAX_VALUE) return 0;
        return length;
    }
}