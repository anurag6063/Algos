package BasicsDSASheet.src.main.java.org.example.bst;

public class Node {
  public int val;
  public Node left;
  public Node right;
  public Node next;

  public Node(int val) {
    this.val = val;
  }

  public Node(int val, Node left, Node right, Node next) {
    this.val = val;
    this.left = left;
    this.right = right;
    this.next = next;
  }

  // Private static method to print a TreeNode as a formatted tree
  private static void printTree(Node node, String indent, boolean isRight) {
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
  public static void printTree(Node root) {
    printTree(root, "", true);
  }
}
