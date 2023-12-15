/*
1. Push elements to stack and keep -1 as sentinent value.
2. Process elements in the stack until a smaller bar is encountered.
3. in the process find height and width, with this the area. then store max area.
4. else just push the element.
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
