/*
https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/description/?envType=list&envId=pheho7s5

sliding window
*/

class Solution {
    public int shortestSubarray(int[] nums, int k) {
    int right =0;
    int left = 0;
    int sum = 0;
    int count =0;
    while(right < nums.length){
        System.out.println(nums[right]);
        sum = sum + nums[right];
        
        if(sum >= k){
             System.out.println("sum achieved at: "+nums[right]);
            while(left < right && sum - nums[left] >= k){
                System.out.println("inside ");
               
                    left++;
                    sum = sum - nums[left];
                    System.out.println("lowering sum from back ");
                
            }
        }
        right++;
    }
    System.out.println(right + " " + left);

    return sum < k  ? -1 : right - left ;
    }
}
 /*
    nums[]
    k = need to reach will k
    shortest - non empty - sub array - sequence is imp. 
    return length of shortest sunarray sum atleast of K
    k = 3
    2, -1, 2 = 
    2 == 3?
    2,-2 > 3 ? No
    2, -2, 1 > 3 Yes


 */      
  /*  int sum = 0;
    for(int i=0; i< nums.length; i++){
        sum += nums[i];
        if(sum >= k){
            int count = i;
            int x = 0;
            while(sum >= k){
                if(sum - nums[x] >= k){
                    count--;
                    sum = sum - nums[x];
                }else{
                    break;
                }
            }
            return count+1;
        }
    }
    return -1;
    }
    */
