package BasicsDSASheet.src.main.java.org.example.tree;

import BasicsDSASheet.src.main.java.org.example.bst.TreeNode;
import java.util.*;

class LevelOrderTraversal {
  // Function to perform level-order
  // traversal of a binary tree
  public List<List<Integer>> levelOrder(TreeNode root) {
    // Create a list of lists to store levels
    List<List<Integer>> ans = new ArrayList<>();
    if (root == null) {
      // If the tree is empty,
      // return an empty list
      return ans;
    }

    // Create a queue to store nodes
    // for level-order traversal
    Queue<TreeNode> q = new LinkedList<>();
    // Push the root node to the queue
    q.add(root);

    while (!q.isEmpty()) {
      // Get the size of the current level
      int size = q.size();
      // Create a list to store
      // nodes at the current level
//      List<Integer> level = new ArrayList<>();

//      for (int i = 0; i < size; i++) {
        // Get the front node in the queue
        TreeNode node = q.poll();
        // Store the node value
        // in the current level list
//        level.add(node.val);
        System.out.print(node.val + " ");
        // Enqueue the child nodes if they exist
        if (node.left != null) {
          q.add(node.left);
        }
        if (node.right != null) {
          q.add(node.right);
        }
      }
      // Store the current level
      // in the answer list
//      ans.add(level);
//    }
    // Return the level-order
    // traversal of the tree
    return ans;
  }


  // Function to print
  // the elements of a list
  static void printList(List<Integer> list) {
    // Iterate through the
    // list and print each element
    for (int num : list) {
      System.out.print(num + " ");
    }
    System.out.println();
  }

  // Main function
  public static void main(String[] args) {
    // Creating a sample binary tree
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.right = new TreeNode(6);
    root.right.right.right = new TreeNode(7);

    // Create an instance
    // of the LevelOrderTraversal class
    LevelOrderTraversal solution = new LevelOrderTraversal();
    // Perform level-order traversal
    List<List<Integer>> result = solution.levelOrder(root);

    System.out.println("Level Order Traversal of Tree:");

    // Printing the level order traversal result
    for (List<Integer> level : result) {
      printList(level);
    }
  }
}

