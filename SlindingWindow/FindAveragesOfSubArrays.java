/*
# Algos
[Note]
[Reference]: 
[Problem]: https://leetcode.com/problems/maximum-average-subarray-i/
[Pattern]: sliding window
[Tips]: use k-1 as check, keep left usage; whenever i have to find a Math.max, one of the value needs to initialized with Integer.MIN_VALUE / Max
[Revision]: 2
[Confidence]: 100%
[Next]: Practice 
[Steps]: 
[Code]	
	
[/Code]
[Tags]: 
[/Note]
*/

// written on own; 
// printing helps
class FindAveragesOfSubArrays {
    public double findMaxAverage(int[] nums, int k) {
        int sumMax = Integer.MIN_VALUE;
        int sum = 0;
        // nums = [1,12,-5,-6,50,3], k = 4 ; sum =0; sumMax=0;
        // System.out.printf(" k %d, sum %d, sumMax %d \n",  k, sum, sumMax);
        int left =0;
        for(int i=0; i<nums.length; i++){
            sum = sum + nums[i];
            // System.out.printf(" nums[] %d, k %d, sum %d, sumMax %d \n", nums[i], k, sum, sumMax);
            if(i >= k-1){  
                sumMax = Math.max(sumMax,sum); 
                sum = sum - nums[left]; // 
                left++;
                // System.out.printf("IN:  nums[] %d, k %d, sum %d, sumMax %d \n", nums[i], k, sum, sumMax);
            }
        }
        return (double)sumMax/k;
    }
// sliding window 

// 2 pointer approach:

// initalize the answer variable.
// check if in any condition we would not like to process anymore.
// 1. initialize: left to 0 initially ;  right side of window will be for loop
// 2. do till:  while/for loop right 0 -> n-1 ; right ++ since the irght one keep movinf always.
// 3.   in: break and return if: Can be multiple conditions
// 4.   in: Do: let right pointer do that it has to do till left kicks in.
//          check for left kick in condition
//          calculate ans first; since this ans is the one for when the 1st window appears.
//          now slide the window from left too/ do modification
//          left++
//          
// 5. change: left ++ and right --; this will be as per some condition or else always.

// Brute force approach
// 6 - 4 - 3
// 1 - 1 - 1

    public double findMaxAverageBruteForce(int[] nums, int k) {
        // if(nums.length < k) return null;
        double avg = Integer.MIN_VALUE;
        for(int i= k-1; i< nums.length ; i++  ){// 5-1 = 4
            double sum =0;
            for( int j= i; j >= i+1-k; j--){ // j=4, j> 4+1-4 
                sum = sum + nums[j];
            }
            avg = Math.max(sum/k, avg);
        }
        return avg;
    }
}
