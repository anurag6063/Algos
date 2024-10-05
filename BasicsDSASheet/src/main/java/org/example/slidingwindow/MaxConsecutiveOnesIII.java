package org.example.slidingwindow;

class MaxConsecutiveOnesIII {

  public int longestOnesBruteForce(int[] nums, int k) {
    int size = nums.length;
    int max = 0;
    for(int i =0; i< size; i++){
      int zero = 0;
      int j = i;
      for( j = i ; j < size; j++){

         System.out.println(" num and index - "+ nums[j] + " : " + j);
        if(nums[j] == 0){
          zero++;
        }
        if(zero > k ){
          break;
        }

      }

      max = Math.max(max, j-i);
       System.out.println(" i  and j - "+ i + " : " + j + " max " + max);

    }

    return max;
  }
// Not sure how i = left worked.
    public int longestOnesOptimized(int[] nums, int k) {
      int size = nums.length;
      int max = 0;
      int left = 0;
      int zero = 0;
      int i =0;
      for(i =0; i< size; i++){

        if(nums[i] == 0){
          zero++;
        }
        if(zero > k ){
          // while(nums[left] != 0 ){
          //     left++;
          // }
          if(nums[left]== 0){ zero--;}
          left++;
        }
        max = Math.max(max, i-left);
        System.out.println(" i  and left - "+ i + " : " + left + " max " + max);
      }
      return i - left;
    }

}

