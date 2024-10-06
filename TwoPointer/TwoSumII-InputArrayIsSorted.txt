

/*
[Note]
[Reference]: 
[Problem]: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/submissions/
[Pattern]: 2 pointers, start from opposite ends.
[Tips]: calulate sum and move pointer l pr r as per comprision b/w sum and tartget. Idea is that according to needed sum,  i can move alter the sum i found from he 2 end elements to reach the sum i need to find.
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

// #Note: use while(l < r){ } when i have 2 pointers on opposite end to start with and i don't want then to cross each other.         
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
