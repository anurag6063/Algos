

/*
[Note]
[Reference]: 
[Problem]: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/submissions/
[Pattern]: 2 pointers
[Tips]: calulate sum and move pointer l pr r as per comprision b/w sum and tartget
[Revision]: 1
[Confidence]: 10%
[Next]: Practice 
[Steps]:
[Code]	
	
[/Code]
[Tags]: 
[/Note]
*/

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
     // since it's soreted i will use 2 pointers app
    
    int l = 0;
    int r = numbers.length-1;
    int sum = Integer.MAX_VALUE;
        
    while(l < r){
        sum = numbers[l]+ numbers[r];
        
        if(sum > target){
            r--;
        }else if( sum < target){
            l++;
        }
        else{
            return new int[]{l+1, r+1};
        }
    }
         return new int[]{-1,-1};
    }
   
}
