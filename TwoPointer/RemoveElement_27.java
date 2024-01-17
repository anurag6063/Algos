
/*
[Note]
[Reference]: 
[Problem]: https://leetcode.com/problems/remove-element/?envType=list&envId=ecumdrrd
[Pattern]: 2 pointers, same direction (for loop)
[Tips]: use left as index var, and right in for loop; same 
[Revision]: 1
[Confidence]: 50%
[Next]: Practice 
[Steps]: replace the value when nums[i] != val; care when it does not matches. 
[Code]	
	if(nums[i] != val){
	 nums[index] = nums[i];
	 index++;
 }
[/Code]
[Tags]: 
[/Note]
*/

class Solution {
        
    public int removeElement(int[] nums, int val) {
         
         int index = 0;
         
         for(int i=0; i< nums.length; i++){
             if(nums[i] != val){
                 nums[index] = nums[i];
                 index++;
             }
             
         }
      
         return index;
     }
	   

     
/*   public int removeElement(int[] nums, int val) {
        int count =0;
        for(int i=0; i< nums.length ; i++){
            System.out.println(val +": "+ nums[i]);
            if(val == nums[i]){
                nums[i]= 100;
                count++;
            }
            // System.out.println(Arrays.toString(nums));
        }
        Arrays.sort(nums);
        // System.out.println("final "+Arrays.toString(nums));
        return nums.length-count;
    }
/*
   /*  public int removeElement(int[] nums, int val) {
        int count = 0;
        int start = end = 0;
        int temp = 0;
        for(int i=0; i< nums.length ; i++){
            System.out.println(val +": "+ nums[i]);
            if(val == nums[i]){
                if(nums[start] != val) start = i;
                end = i;
                count++;
            }
            // System.out.println(Arrays.toString(nums));
        }
        Arrays.sort(nums);
        // System.out.println("final "+Arrays.toString(nums));
        return nums.length-count;
    }
    */


}

