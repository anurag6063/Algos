/*https://leetcode.com/problems/daily-temperatures/submissions/1122632944/?envType=list&envId=pheho7s5

Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

*/

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] ans = new int[len];
        Stack<int[]> stack = new Stack<>();

        for(int i = len-1; i>=0; i--){
            if(stack.isEmpty()){
                ans[i] = 0;
            }else if(stack.peek()[0] > temperatures[i]){
                ans[i] = stack.peek()[1] - i;
            }else {
                while(!stack.isEmpty() && stack.peek()[0] <= temperatures[i]){
                    stack.pop();
                }

                if(stack.isEmpty()){
                    ans[i]= 0;
                }else if(stack.peek()[0] > temperatures[i]){
                    ans[i] = stack.peek()[1] - i;
                }
            }
            stack.push(new int[]{temperatures[i], i});
        }

        return ans;

    }
}