/// https://leetcode.com/problems/subsets/

package org.example.recursion;

import java.util.ArrayList;
import java.util.List;

public class AllSubSets {
    public List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> res = new ArrayList<> ();
      List<Integer> data = new ArrayList<>();
      recursion(nums, 0 , data, res);
      return res;
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
