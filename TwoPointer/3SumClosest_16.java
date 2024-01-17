
/*
[Note]
[Reference]: 
[Problem]: https://leetcode.com/problems/3sum-closest/?envType=list&envId=ecumdrrd
[Pattern]: 2 pointers, opposite dir
[Tips]: Calculate sum, and move pointer accordingly; comapre target-sum < target-sum 
[Revision]: 0
[Confidence]: 10%
[Next]: Practice 
[Steps]: 2 loops, out for loop controls I, inside is 2 pointers, calulate sum, update ans = sum if Math.abs(target-sum) < Math.abs(target-ans
[Code]	
	if(Math.abs(target-sum) < Math.abs(target-ans)){
       ans = sum;
    }
[/Code]
[Tags]: 
[/Note]
*/


class Solution {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE; // or can be sum of first 3 values

        for(int i =0; i< nums.length-2; i++){
            int l = i+1;
            int r = nums.length - 1;

            while(l < r){
                int sum = nums[i]+ nums[l]+ nums[r] ;
            
                // this is special, rest is template of 2 pointers
                if(Math.abs(target-sum) < Math.abs(target-ans)){
                    ans = sum;
                }
                if(sum < target)
                {l++;}
                else{r--;}
                
            }
            
        }
        return ans;
    }
}