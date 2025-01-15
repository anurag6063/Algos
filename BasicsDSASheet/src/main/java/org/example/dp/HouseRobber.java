/*
//package BasicsDSASheet.src.main.java.org.example.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class HouseRobber {


    public int rob(int[] nums) {
        return rob(nums, nums.length - 1);
    }

    private int rob(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }
        return Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
    }

//    -- below code does not works in all teat cases in leetcode

  private static int solve(ArrayList<Integer> arr) {
    int n = arr.size();
    int prev = arr.get(0);
    int prev2 = 0;

    for (int i = 1; i < n; i++) {
      int pick = arr.get(i);
      if (i > 1) {
        pick += prev2;
      }
      int nonPick = prev;
      int cur_i = Math.max(pick, nonPick);

      prev2 = prev;
      prev = cur_i;
    }
    return prev;
  }
// ---

  */
/**

   We have money array.
   The last house and the first is connected since it's circular.
   At each place i have 2 options, choose or not choose.
   After finding all combination i can decide.

   How to handle the circular issue.
   I can add the first element as last. And can somehow indicate if it's been robbed.
   So ideally if i rob first house i cannot the last one, arr to arr-1
   Or if i do not rob first house i can, the last house arr-1, arr.

   So find ans for both such array and find the max.

   *//*

  public int rob(int[] nums) {
    if(nums.length == 0){
      return 0;
    }
    if(nums.length == 1){
      return nums[0];
    }
    // using these 2 array since i the houses are in circle.
    // i have 2 options either to rod first one of last one. So rather that handling as a flag etc.
    // done usign 2 separate calls and finding the final ans.
    int[] nums1 = Arrays.copyOfRange(nums, 1, nums.length); // good way of copying
    int[] nums2 = Arrays.copyOfRange(nums, 0, nums.length-1);

    int num1Max = solve(nums1, nums1.length-1);
    int num2Max = solve(nums2, nums2.length-1);

    return Math.max(num1Max, num2Max);

  }

  private static int solve(int[] nums, int n){
    if(n < 0){
      return 0;
    }
    int choose = nums[n] + solve(nums, n-2); // when i rob i need to jump 2 places, so as not to get caught
    int notChoose = solve(nums, n-1); // when did not rob i can got to next one.

    return Math.max(choose, notChoose);
  }


  // --
  // using memoization

    public int rob(int[] nums) {
      if(nums.length == 0){
        return 0;
      }
      if(nums.length == 1){
        return nums[0];
      }

      int[] nums1 = Arrays.copyOfRange(nums, 1, nums.length);
      int[] nums2 = Arrays.copyOfRange(nums, 0, nums.length-1);
      // use 2 memos else the same array gets passed and the answer is corrupted.
      int[] memo1 =  new int[nums.length-1];
      Arrays.fill(memo1, -1);

      int[] memo2 =  new int[nums.length-1];
      Arrays.fill(memo2, -1);

      int num1Max = solve(nums1, nums1.length-1, memo1);
      int num2Max = solve(nums2, nums2.length-1, memo2);

      return Math.max(num1Max, num2Max);

    }

    private static int solve(int[] nums, int n, int[] memo){
      if(n < 0){
        return 0;
      }
      if(memo[n] != -1){
        return memo[n];
      }

      int choose = nums[n] + solve(nums, n-2, memo);
      int notChoose = solve(nums, n-1, memo);

      return memo[n] = Math.max(choose, notChoose);
    }
  }
}*/
