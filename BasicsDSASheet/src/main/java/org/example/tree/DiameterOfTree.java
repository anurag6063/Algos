package BasicsDSASheet.src.main.java.org.example.tree;
// Importing necessary packages
import BasicsDSASheet.src.main.java.org.example.bst.TreeNode;

import java.util.*;
class DiameterOfTree {
  // Global variable to
  // store the diameter
  int diameter = 0;

  // Function to calculate
  // the height of a subtree
  int calculateHeight(TreeNode TreeNode) {
    if (TreeNode == null) {
      return 0;
    }

    // Recursively calculate the
    // height of left and right subtrees
    int leftHeight = calculateHeight(TreeNode.left);
    int rightHeight = calculateHeight(TreeNode.right);

    // Calculate the diameter at the current
    // TreeNode and update the global variable

    // this code is exactly like recursive solution for Height of binary tree, just that here
    // i have chosen and set a global variable with the max dia at current time.
    diameter = Math.max(diameter, leftHeight + rightHeight);

    // Return the height
    // of the current subtree
    return 1 + Math.max(leftHeight, rightHeight);
  }

  // Function to find the
  // diameter of a binary tree
  int diameterOfBinaryTree(TreeNode root) {
    // Start the recursive
    // traversal from the root
    calculateHeight(root);

    // Return the maximum diameter
    // found during traversal
    return diameter;
  }


  public int diameterOfBinaryTreeSelf(TreeNode root) {
    if(root == null){
      return 0;
    }

    return findMaxDia(root)-1;
  }

  private static int findMaxDia(TreeNode node){
    if(node == null){
      return 0;
    }

    int left = findHeight(node.left);
    int right = findHeight(node.right);

    int maxL = findMaxDia(node.left);
    int maxR = findMaxDia(node.right);
    int max = Math.max(left + right + 1, maxL);
    return Math.max(max, maxR);
  }

  private static int findHeight(TreeNode node){
    if(node == null){
      return 0;
    }

    int left = findHeight(node.left)+1;
    int right = findHeight(node.right)+1;

    return Math.max(left, right);
  }

  // Main method
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
    DiameterOfTree solution = new DiameterOfTree();

    // Calculate the diameter of the binary tree
    int diameter = solution.diameterOfBinaryTree(root);
    int diameterOfBinaryTreeSelf = solution.diameterOfBinaryTreeSelf(root);

    System.out.println("The diameter of the binary tree is: " + diameter);
    System.out.println("The diameter of the binary tree is: " + diameterOfBinaryTreeSelf);

  }
}

                                
                            