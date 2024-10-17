package BasicsDSASheet.src.main.java.org.example.bst;

public class TreeNode {

  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
  // Private static method to print a TreeNode as a formatted tree
  private static void printTree(TreeNode node, String indent, boolean isRight) {
    if (node == null) {
      return;
    }

    // Print the current node
    System.out.println(indent + (isRight ? "└── " : "├── ") + node.val);

    // Recursively print the left and right children with increased indentation
    indent += isRight ? "    " : "│   ";
    printTree(node.left, indent, false);
    printTree(node.right, indent, true);
  }

  // Wrapper method to call printTree
  public static void printTree(TreeNode root) {
    printTree(root, "", true);
  }
}
