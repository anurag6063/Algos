/// https://leetcode.com/problems/subsets/

package org.example.recursion;

import java.util.ArrayList;
import java.util.List;

public class AllSubSets {
    public List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> res = new ArrayList<> (); // #Memorize - to create a list of list
      List<Integer> data = new ArrayList<>();
      recursion(nums, 0 , data, res);
      return res;
    }

    public List<List<Integer>> subsets2(int[] nums) {
      List<List<Integer>> res = new ArrayList<>();
      List<Integer> data = new ArrayList<>();
      recursion2(nums, 0, data, res);
      return res;
    }

    private static void recursion2(int[] nums, int index, List<Integer> data, List<List<Integer>> res) {
      if(index == nums.length) {
        res.add(new ArrayList<>(data));
      }

      data.add(nums[index]);
      recursion2(nums, index + 1, data, res);

      data.remove(data.size() - 1);
      recursion2(nums, index + 1, data, res);
    }


    void recursion(int[] nums, int index , List<Integer> data , List<List<Integer>> res){
      if(index >= nums.length){
        res.add(new ArrayList<>(data));
        return;
      }

      data.add(nums[index]);
      recursion( nums, index+1, data , res);

      data.remove(data.size() -1);
      recursion(nums, index+1, data, res);

      // return res;
    }

}
