
/*
[Note]
[Reference]: 
[Problem]: https://leetcode.com/problems/remove-duplicates-from-sorted-array/?envType=list&envId=ecumdrrd
[Pattern]: 2 ponters, same direction (var + for loop)
[Tips]: think when it does not matches, i will replace. 
[Revision]: 0
[Confidence]: 10%
[Next]: Practice 
[Steps]: check for not matching nos in same direction. 
[Code]	
	if(nums[i] != nums[i-1]){
		nums[index] = nums[i];
		index++;
	}
[/Code]
[Tags]: #RemoveElement_27
[/Note]
*/

class Solution {
    public int removeDuplicates(int[] nums) {
      // [0,0,1,1,1,2,2,3,3,4] -> [0,1,2,3,4,_,_,_,_,_]
//      init   [0,0<index><i>,1,1,1,2,2,3,3,4]
//      i=0    [0,0<index><i>,1,1,1,2,2,3,3,4]
        // [0,0<index>,1<i>,1,1,2,2,3,3,4]
        // [0,1,1<index>,1<i>,1,2,2,3,3,4]
        // [0,1,1<index>,1,1<i>,2,2,3,3,4]
         // [0,1,1<index>,1,1,2<i>,2,3,3,4]
        // [0,0,1,1,1,2,2,3,3,4] - [0,1,2,2,3,3,4] - [0,1,2,3,4]
        int index = 1;
        
        for(int i=1; i< nums.length; i++){
            // System.out.println("index "+ index + " i "+ i);
            if(nums[i] != nums[i-1]){
                // System.out.println( "replace");
                nums[index] = nums[i];
                index++;
            }
            // System.out.println(Arrays.toString(nums));
            // Arrays.asList(nums).forEach(k -> System.out.print(k));
            
        }
        return index;
    }
}