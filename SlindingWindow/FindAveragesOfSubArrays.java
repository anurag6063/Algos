// sliding window 
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
