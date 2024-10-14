package org.example.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

  public static void main(String[] args) {
    CombinationSum sol = new CombinationSum();

    // Example input
    int[] candidates = {2, 3, 6, 7};
    int target = 7;

    // Call the combinationSum method and store the result
    List<List<Integer>> result = combinationSum(candidates, target);

    // Print the result
    System.out.println("Combinations that sum up to " + target + ":");
    for (List<Integer> combination : result) {
      System.out.println(combination);
    }
  }

  public static List<List<Integer>> combinationSum(int[] candidates, int target) {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> curr = new ArrayList<>();
    findSum( candidates, target, 0 , curr, res);

    return res;
  }

  static void findSum(int[] arr, int target, int i , List<Integer> curr,
      List<List<Integer>> res ){
    if(i == arr.length-1){
      res.add(curr);
      return ;
    }

    curr.add(arr[i]);
    findSum(arr, target-arr[i], i+1, curr, res);

    curr.remove(curr.size()- i);
    findSum(arr, target, i-1, curr, res);

    // return res;
  }
}
