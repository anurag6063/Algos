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
class Solution {
    public double findMaxAverage(int[] nums, int k) {

      
        int sumMax = Integer.MIN_VALUE;
        int sum = 0;
        // nums = [1,12,-5,-6,50,3], k = 4 ; sum =0; sumMax=0;
        // System.out.printf(" k %d, sum %d, sumMax %d \n",  k, sum, sumMax);
        int left =0;
        for(int i=0; i<nums.length; i++){ 
            
            printArrayAndIndices(nums, left, i);
            
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

   private void printArrayAndIndices(int[] nums, int left, int i) {
    System.out.print("Index: ");
    for (int j = 0; j < nums.length; j++) {
        System.out.printf("%-4d", j);
    }
    System.out.println();
    
    System.out.print("Array: ");
    for (int j = 0; j < nums.length; j++) {
        System.out.printf("%-4d", nums[j]);
    }
    System.out.println();
    
    System.out.print("      ");
    for (int j = 0; j < nums.length; j++) {
        if (j < left || j > i) {
            System.out.print("    ");
        } else {
            System.out.print("  ^ ");
        }
    }
    System.out.println();
    System.out.println("Left index: " + left);
    System.out.println("Current index (i): " + i);
    System.out.println();
}

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

class Solution{

    public double findMaxAverage(int[] nums, int k){

        double sum = 0;
        double max = Integer.MIN_VALUE;

        // use sliding window
        int left = 0;
        for(int right = 0; right < nums.length ; right++){

            sum = sum + nums[right];
            // System.out.println(left +" : " + right +" sum "+ sum);

            if(right >= k-1){
                max = Math.max(sum, max);
                sum = sum - nums[left];    
                // System.out.println("in: "+ sum + " max "+ max);
                left++;
            }
                        
        }

        return max/k;

    }
}

// Brute force approach
// 6 - 4 - 3
// 1 - 1 - 1
/*class Solution {
    public double findMaxAverage(int[] nums, int k) {

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
*/

//--------------------------
/*class Solution {
    public double findMaxAverage(int[] nums, int k) {
        // ontiguous subarray - sequence is imp
        // find avh that's the ans'
        // max average

        if(nums.length == 1) return nums[0];
        // if(nums.length-1 == k) {

        // }

        // int[] sums = new sums[nums.length];
        // int sum = 0;
        // for(int i=0; i< k-1; k++){
        //     sum = sum + nums[i];
        // }
        // sums[0]= sum;

        // need to implement this
        
        // System.out.println("initializing: "+nums.length + " : "+ k);
        int left = 0, right = k-1 ;
        double avg = Integer.MIN_VALUE, curr = Integer.MIN_VALUE;
        while(right < nums.length){
            // System.out.println( "loopin: "+left + " " + right + ": "+ k);
            double sum =0;
            int temp=left;
            // find new avg
            while( temp <= right){
                sum = sum + nums[temp];
                temp++;
            }
            // System.out.println("sum "+ sum);
            curr = sum/k;
            // System.out.println(curr + " : " + avg);
            avg = Math.max(avg, curr);
        right++;
        left++;
        }

    return avg;
    }
}
*/
