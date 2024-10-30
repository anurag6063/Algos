package BasicsDSASheet.src.main.java.org.example.tree;


// Importing necessary packages
import BasicsDSASheet.src.main.java.org.example.bst.TreeNode;
import java.util.*;

public class MaximumPathSum {

// Node structure for the binary tree

  // Recursive function to find the maximum path sum
  // for a given subtree rooted at 'root'
  // The variable 'maxi' is a reference parameter
  // updated to store the maximum path sum encountered
  int findMaxPathSum(TreeNode root, int[] maxi) {
    // Base case: If the current TreeNode is null, return 0
    if (root == null) {
      return 0;
    }

    // Calculate the maximum path sum
    // for the left and right subtrees
    int leftMaxPath = Math.max(0, findMaxPathSum(root.left, maxi));
    int rightMaxPath = Math.max(0, findMaxPathSum(root.right, maxi));

    // Update the overall maximum
    // path sum including the current TreeNode
    maxi[0] = Math.max(maxi[0], leftMaxPath + rightMaxPath + root.val);

    // Return the maximum sum considering
    // only one branch (either left or right)
    // along with the current TreeNode
    return Math.max(leftMaxPath, rightMaxPath) + root.val;
  }

  // Function to find the maximum
  // path sum for the entire binary tree
  int maxPathSum(TreeNode root) {
    // Initialize maxi to the
    // minimum possible integer value
    int[] maxi = {Integer.MIN_VALUE};

    // Call the recursive function to
    // find the maximum path sum
    findMaxPathSum(root, maxi);

    // Return the final maximum path sum
    return maxi[0];
  }

  public static void main(String[] args) {
    // Creating a sample binary tree
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.left.right.right = new TreeNode(6);
    root.left.right.right.right = new TreeNode(7);

    // Creating an instance of the Solution class
    MaximumPathSum solution = new MaximumPathSum();

    // Finding and printing the maximum path sum
    int maxPathSum = solution.maxPathSum(root);
    System.out.println("Maximum Path Sum: " + maxPathSum);
  }
}

