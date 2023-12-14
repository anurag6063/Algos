/*

3,0,0,2,0,4

3 - L -1 R - 4  = less of both  - own height
0 - L - 3, R - 4, = 3 - 0
0 - L - 3, R - 4 = 3 - 0
2 - L - 3, R- 4 = 
0 - L - 3, R - 4 = 0 - 3
4 - L - 3, R - -1 = 3 -4 = -1 
only take positive


1. find the maximum elemnt to your left.
2. find max no to your right
3. find the lower of max to your left and right
4. find the area that it supports by minus own height and it should be postive

*/

/*

https://leetcode.com/problems/trapping-rain-water/?envType=list&envId=pheho7s5
1. find max to it's left
2. find max to it's right
3. find min of both left and right at an index
4. find the diff /0 between current height and the min.
5. the sum of step 4 is ans.
*/

class Solution {


    public int trap(int[] height) {
        if(height == null || height.length < 2){
            return 0;
        }

        int n = height.length;
        // find max to wareds int's left and right
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];


        maxLeft[0]= height[0];
        for(int i=1; i< n ; i++){
            maxLeft[i]= Math.max(height[i], maxLeft[i-1]);
        }

        maxRight[n-1] = height[n-1];
        for(int i=n-2; i >= 0; i--){
            maxRight[i] = Math.max(height[i], maxRight[i+1]);
        }

        int trappedWater = 0;

        for(int i=0; i< n; i++){
            int minHeight = Math.min(maxRight[i], maxLeft[i]);
            trappedWater += Math.max(0, minHeight-height[i]);
        }

        return trappedWater;
    }

}
    /*
    public int trap(int[] height) {
        // trapping rain water.
        // histogram
        // [0, 1,0,2,1,0,1,3,2,1,2,1]
        // -1,-1,1,1,2,2,2,2,2,2,2,2
        //  2, 2,2,2,2,2,2,3,2,2,2,-1
        //  0, 0,1,0,1,2,1,0,0,1,0,-1
// find the nearest greater no on the left,
// find nearest greater no of the right
// find the min of above both
// decrease the height from the min
// sum of the last step is the amount of water.

    ngl(height);


return 0;


    }
    public static int[] ngl(int[] height){
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[height.length];
        for(int i=0; i< height.length; i++){
            if(stack.isEmpty()){
                ans[i]= -1;
            }else if(!stack.isEmpty() && stack.peek()> height[i]){
                ans[i]= stack.peek();
            }else{
                while(!stack.isEmpty() && stack.peek()< height[i]){
                    stack.pop();
                }

                if(stack.isEmpty()){
                    ans[i] = -1;
                }else{
                    ans[i] = stack.peek();
                }
            }

            stack.push(height[i]);
        }
        System.out.println("ans");
        Arrays.stream(ans).forEach(s -> System.out.println(s));
        return ans;
    }

    
}

*/

// chatGPT
import java.util.Stack;

public class TrappingRainWater {

    public static int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }

        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        // Initialize leftMax array
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // Initialize rightMax array
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int trappedWater = 0;
        for (int i = 0; i < n; i++) {
            int minHeight = Math.min(leftMax[i], rightMax[i]);
            trappedWater += Math.max(0, minHeight - height[i]);
        }

        return trappedWater;
    }

    public static void main(String[] args) {
        int[] elevationMap = {0,1,0,2,1,0,1,3,2,1,2,1};
        int trappedWater = trap(elevationMap);
        System.out.println("Trapped water: " + trappedWater);
    }
}
