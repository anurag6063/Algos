/*
# Algos
[Note]
[Reference]: 
[Problem]: https://leetcode.com/problems/maximum-depth-of-binary-tree/
[Pattern]: 
[Tips]: 
[Revision]: 0
[Confidence]: 10%
[Next]: Need to implement myown sol.  
[Steps]: 
[Code]	
	
[/Code]
[Tags]: 
[/Note]
*/
/**
 * 
Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
*/
import java.util.Stack;

public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        // Create a stack to keep track of indices of histogram bars
        Stack<Integer> stack = new Stack<>();
        // Variable to store the maximum area
        int maxArea = 0;

        // Iterate through the heights array and one additional iteration with a sentinel value
        for (int i = 0; i <= heights.length; i++) {
            // Use -1 as a sentinel value to handle the remaining elements on the stack
            int h = (i == heights.length) ? -1 : heights[i];

            // Process elements in the stack until a smaller bar is encountered
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                // Pop the bar from the stack
                int height = heights[stack.pop()];
                // Calculate the width of the rectangle
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                // Calculate the area of the rectangle formed by the popped bar
                int area = height * width;
                // Update the maximum area if needed
                maxArea = Math.max(maxArea, area);
            }

            // Push the current index onto the stack
            stack.push(i);
        }

        // Return the maximum area
        return maxArea;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram solution = new LargestRectangleInHistogram();
        int[] heights = {2, 1, 5, 6, 2, 3};
        int result = solution.largestRectangleArea(heights);
        System.out.println("Output: " + result); // Output: 10
    }
}
