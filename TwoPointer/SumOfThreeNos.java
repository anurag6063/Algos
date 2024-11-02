
/*
[Note]
[Reference]: https://www.youtube.com/watch?v=onLoX6Nhvmg&list=PLgUwDviBIf0rBT8io74a95xT-hDFZonNs
[Problem]: https://leetcode.com/problems/3sum/?envType=list&envId=ecumdrrd
[Pattern]: 2 pointers, opp end
[Tips]: instead of 3, use 2 pointers to reduce one inside loop, sort the values. use while loop to skip same number since we don't want dupicate nums. Use a linkedList; keep sum = 0 - nums[i] i.e A, 
[Revision]: 1
[Confidence]: 30%
[Next]: Practice 
[Steps]: Use a linked lis
[Code]	
	ans.add(Arrays.asList(nums[i], nums[left], nums[right]))
[/Code]
[Tags]: 
[/Note]

question: "https://leetcode.com/problems/3sum/?envType=list&envId=ecumdrrd"
problemStatement: |
    nums = [-1,0,1,2,-1,-4] given an array find a set of 3 non-duplicate numbers
    that add up to given sum.

intuition: |
    Since I am being asked to find sum of 3 nos.
    instead of 3, use 2 pointers to reduce one inside loop, sort the values. use while loop to skip
    same number since we don't want duplicate nums.
    Use a linkedList; keep sum = 0 - nums[i] i.e A,
diagram: ""
pattern: ["2 pointers, opp end"]
solutionReference: "https://www.youtube.com/watch?v=onLoX6Nhvmg&list=PLgUwDviBIf0rBT8io74a95xT-hDFZonNs"
confidence: ""

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SumOfThreeNos {
     public List<List<Integer>> threeSum(int[] nums) {
         // brute force use 3 loops
        // a+b+c = 0 or a = - (b+c)
        List<List<Integer>> ans = new LinkedList<>();
        Arrays.sort(nums);

        for(int i=0; i< nums.length-2; i++){
        // 2 pointers here
          if( i == 0 || ( i > 0 && nums[i] != nums[i-1])){
              int left = i+1;
              int right = nums.length-1;
              int sum = 0 - nums[i]; // this is what i will want to achieve below.

              while(left < right){
                  if(nums[left] + nums[right] == sum){
                      ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                      // to skip some extra work
                      while(left < right && nums[left] == nums[left+1]) left++ ;
                      while(left < right && nums[right] == nums[right-1]) right--;
                      left++;
                      right--;
                  }
                  else if( nums[left] + nums[right] < sum)
                    {
                      left++;
                    }
                  else{
                    right--;
                  }
              }
          }
        }
        return ans;
     }

}
  private List<List<Integer>> findTriplet(int[] nums){
       List<List<Integer>> result = new ArrayList<>();
         for(int i=0; i< nums.length;i++){
             for(int j=i+1; j< nums.length ; j++){
                 for(int k=j+1; k< nums.length; k++){
                     if(nums[i]+ nums[j]+ nums[k] == 0){
                        ArrayList<Integer> arrayList = new ArrayList<>();
                        arrayList.add(nums[i]);
                        arrayList.add(nums[j]);
                        arrayList.add(nums[k]);
                        result.add(arrayList);
                     }
                 }
             }
         }
         return result;
     }

public void main() {
}