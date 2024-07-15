class Solution {
    public List<String> summaryRanges(int[] nums) {
        
        List<String> ans = new ArrayList<>();
        StringBuffer element = new StringBuffer();

        for(int i=0; i<nums.length; i++){
            if(i < nums.length-1 && nums[i] == nums[i+1]-1){
                // if consecutive
                element.append(nums[i]).append("->");
                while(i < nums.length-1 && nums[i] == nums[i+1]-1){
                    i++;
                }
                element.append(nums[i]);
                ans.add(element.toString());
                element.setLength(0);
            }else{
                ans.add(nums[i]+"");
            }
        }

        return ans;
    }
}
