/*
https://leetcode.com/problems/next-greater-element-ii/solutions/98262/typical-ways-to-solve-circular-array-problems-java-solution/?envType=list&envId=pheho7s5

*/
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        // instantiate the stack with all the elemnts from the bakc to front, rest all remains same

        int[] ans = new int[nums.length]; // 1,2,1
        Stack<Integer> stack = new Stack<Integer>(); // NULL -> 1,2,1

        for(int i = nums.length-1; i>=0; i--){ 
            stack.push(nums[i]); // 
        }
        // stack.forEach(System.out::println);
        // System.out.println("---");

        for(int i = nums.length-1; i>=0; i--){ 
            System.out.println("value in "+  nums[i]);
            if(stack.isEmpty()){
                ans[i] = -1; 
            //    System.out.println("index in empty "+  i); 
            }else if(nums[i] < stack.peek()){
                ans[i] = stack.peek();
                //  System.out.println("found 1 -index in "+  i); 
            }else{
                while(!stack.isEmpty() && stack.peek() <= nums[i]){
                    stack.pop();
                }

                if(stack.isEmpty()){
                    ans[i] = -1;
                }else{
                    ans[i] = stack.peek();
                }
            }

            stack.push(nums[i]);

        }   

        return ans;
    }
}