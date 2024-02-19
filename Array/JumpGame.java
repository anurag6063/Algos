/*
[Note]
[Reference]: 
[Problem]: https://leetcode.com/problems/jump-game/description/
[Pattern]: Add and check max
[Tips]: Remember it's not about reaching the last index exactly, it's just about reaching the finish line. The only time it can not reach is when the index where its stands is greater than reachable limit, (this is how it's designed)
[Revision]: 1
[Confidence]: 10%
[Next]: Practice 
[Steps]: loop all element, if(i > reachable ) return ; else Math.max(reachablem i+nums[i]
[Code]	
	
[/Code]
[/Note]
*/

/**
 * 
 * https://leetcode.com/problems/jump-game/description/
 * 
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

    Return true if you can reach the last index, or false otherwise.
 */
class Solution {

    public boolean canJump(int[] nums){

        // initialize
        int stepsICantake = nums[0];
        int getStepsOf = 1;

        while(stepsICanTake > 0){
            if(getStepsOf == nums.length-1) return true;
            stepsICanTake = Math.max(stepsICanTake-1, nums[getStepsOf]);
            getStepsOf++;
        }
        return false;        
    }
}


class Solution4 {

    public boolean canJump(int[] nums){
        if(nums.length < 2) return true;
        // initialize 
        // starting point

        // i will always have at the start, initialize the data in same way.
        int stepsLeft = nums[0]; // this is how much it can go initally
        int index = 1 ; // this is what it can get next

        while(stepsLeft > 0){ // i can go ahead till i have steps remaining
            if(index == nums.length-1) return true; // if i reached end ; return true
            stepsLeft = Math.max(stepsLeft-1, nums[index]);  // how many more steps can i go, its max of how many steps i am left or else i can take the new steps power that i have
            // go to next index
            index++;
        }

        return false;
    }
}

class Solution {
    public boolean canJump(int[] nums) {
       int reachable = 0;
       // go till end. 
       for(int i = 0; i < nums.length; i ++) {
        // if anytime the index falls behind the reachable limit. return false and exit.
           if(i > reachable){ return false;}
           reachable = Math.max(reachable, i + nums[i]);
           System.out.printf("IN: reachable %d, i %d , nums[i] %d, \n", reachable, i, nums[i]);
       } 
       return true;
    }
}

/*
class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int max = nums[0]; 
        int index = 0;
        for(int i=0; i< len ; i++){ 
            if(len <= max){
                return true;
            }
            max = nums[i+1];
            System.out.println("jump no of times: "+ nums[i]);
            for(int j=0;j < nums[i] ; j++){
                // max = Math.max(nums[j+i], max);
                if(nums[j+i] > max){
                    index = j+i;
                    max = nums[j+i];
                }
                // if(max == nums[j+i]) index = j;
                System.out.printf("IN: index %d, i %d , j %d, max %d \n", index, i, j , max);
            }

            System.out.printf("index %d, i %d , max %d \n", index, i, max);

            i = index-1;
        }

        return false;
    }
}

*/

// 2,3,1,1,4
//  [3,2,1,0,4]
/*
len = 5
max = 2
index =  0

i= 0-> len
    j= 0-> nums[i]


*/