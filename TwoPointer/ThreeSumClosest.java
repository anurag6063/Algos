/*
question: "https://leetcode.com/problems/3sum-closest/?envType=list&envId=ecumdrrd"
problemStatement: "Find a set of 3 nums whose sum is closest to target value."
intuition: |
    To find this i can first find list of all possible sums. From this then I can find difference
    from target. Now i can store all values of difference and sort them.
    the smallest num will be ans.

    To find list of all possible sums i can optimized it.
    By doing sorting first then using 2 pointers from opp direction.

    Old: 2 loops, out for loop controls I, inside is 2 pointers, calulate sum, update ans = sum if Math.abs(target-sum) < Math.abs(target-ans

    	if(Math.abs(target-sum) < Math.abs(target-ans)){
       ans = sum;
    }

diagram: ""
pattern: []
solutionReference: ""
*/
import java.util.Arrays;

class ThreeSumClosest {
  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int ans = Integer.MAX_VALUE; // or can be sum of first 3 values

    for (int i = 0; i < nums.length - 2; i++) {
      int l = i + 1;
      int r = nums.length - 1;
      while (l < r) {
        int sum = nums[i] + nums[l] + nums[r];
        // this is special, rest is template of 2 pointers
        if (Math.abs(target - sum) < Math.abs(target - ans)) {
          ans = sum;
        }
        if (sum < target) {
          l++;
        } else {
          r--;
        }
      }
    }
    return ans;
  }
}