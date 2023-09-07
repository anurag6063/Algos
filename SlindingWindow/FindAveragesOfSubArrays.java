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
