package org.example.BasicDS;
import java.util.Arrays;

public class Reverse {
    public static void main(String[] args) {
      System.out.println("Hello World");
      int[] nums = {5,9,3,2,1};
      int from = 0;
      int n = 5;

      nums = reverse(0, n, nums);
      // Arrays.toString(nums);
      System.out.println(Arrays.toString(nums));
    }

    private static int[] reverse(int i, int size, int[] nums){
      if(i >= size/2){
        return nums;
      }
      System.out.println("i "+ i );

      int temp = nums[size-1-i];
      nums[size-1-i] = nums[i];
      nums[i] = temp;

      return reverse(++i, size, nums);
    }
  }

