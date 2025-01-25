/*
package BasicsDSASheet.src.main.java.org.example;

public class Sample {
  public int equalPairs(int[][] grid) {
    // 0 indexed
    // n * n - that's equal size
    // return pairs
    // equal means row and column contains same element is same order
    // return just the count as int.
    // loop i and loop j compare if till end matched count ++

    int count = 0;
    for (int row = 0; row < grid[0].length; row++) { // this should be grid.length
      for (int col = 0; col < grid[0].length; col++) {
        System.out.println("row: " + row + " col: " + col);
        System.out.println(grid[row][col]);
        boolean equal = true;
        for (int x = 0; x < grid[0].length; x++) {
          if (grid[row][x] != grid[x][col]) {
            equal = false;
            break;
          }
        }
        if (equal) {
          count++;
        }
      }
    }
    return count;
  }

  // Driver code to test the solution
  public static void main(String[] args) {
    // Create a matrix (grid)
    int[][] grid = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };

    // Create an instance of Solution
    Solution solution = new Solution();

    // Call equalPairs and print the result
    int result = solution.equalPairs(grid);

    // Print the result
    System.out.println("Number of equal pairs: " + result);
  }
}
*/
