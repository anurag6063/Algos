
/*
[Note]
[Reference]: https://leetcode.com/problems/4sum/solutions/8609/my-solution-generalized-for-ksums-in-java https://leetcode.com/problems/4sum/solutions/3138504/java-easy-to-understand-accepted
[Problem]: https://leetcode.com/problems/4sum/?envType=list&envId=ecumdrrd
[Pattern]: 2 pointers, opposite
[Tips]: use 2 for loop and one 2 pointer, sort the values first
[Revision]: 0
[Confidence]: 10%
[Next]: Practice 
[Steps]: 
[Code]	
	
[/Code]
[Tags]: 
[/Note]
*/




class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        Set<List<Integer>> ans = new HashSet<>();
        // List<List<Integer>> ans = new LinkedList<>();
        Arrays.sort(nums);
        // Arrays.asList(nums).forEach(System.out::println);
        Arrays.stream(nums).forEach(s -> System.out.println(s));
        for(int i=0; i< nums.length-3; i++){
            // System.out.println(i + " "+ nums[i]);
            for(int j= i+1; j < nums.length-2; j++){
                int l = j+1;
                int r = nums.length-1;
                System.out.printf("nums %d , %d, %d, %d index %d, %d, %d, %d \n",nums[i], nums[j], nums[l], nums[r], i, j, l, r);
                while(l<r){
                    long sum = (long)nums[i]+ (long)nums[j]+ (long)nums[l]+ (long)nums[r];
                    if(sum == target){
                        ans.add(List.of( nums[i],nums[j],nums[l],nums[r]));
                        // while(l < r && nums[l] == nums[l+1]) {l++ ;}
                        // while(l < r && nums[r] == nums[r-1]) {r--;}
                    
                        l++;
                        r--;
                    }else if( sum < target){
                        l++;
                    }else{
                        r--;
                    }
                    
                }
            }
        }

        return new ArrayList<>(ans);
        // return ans;
    }
}