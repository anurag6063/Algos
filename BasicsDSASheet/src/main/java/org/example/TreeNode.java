package BasicsDSASheet.src.main.java.org.example;

public class TreeNode {
  public int val;
  public TreeNode left;
  public TreeNode right;
  public TreeNode() {}
  public TreeNode(int val) { this.val = val; }
  public TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }


  // In-order Traversal (Left, Root, Right)
  public static void printInOrder(TreeNode root) {
    if (root != null) {
      printInOrder(root.left);
      System.out.print(root.val + " ");
      printInOrder(root.right);
    }
  }

  // Pre-order Traversal (Root, Left, Right)
  public static void printPreOrder(TreeNode root) {
    if (root != null) {
      System.out.print(root.val + " ");
      printPreOrder(root.left);
      printPreOrder(root.right);
    }
  }

  // Post-order Traversal (Left, Right, Root)
  public static void printPostOrder(TreeNode root) {
    if (root != null) {
      printPostOrder(root.left);
      printPostOrder(root.right);
      System.out.print(root.val + " ");
    }
  }

  public static void main(String[] args) {
    // Creating the Binary Search Tree manually
    TreeNode root = new TreeNode(50);
    root.left = new TreeNode(30);
    root.right = new TreeNode(70);
    root.left.left = new TreeNode(20);
    root.left.right = new TreeNode(40);
    root.right.left = new TreeNode(60);
    root.right.right = new TreeNode(80);

    // Print In-order traversal
    System.out.print("In-order Traversal: ");
    printInOrder(root);
    System.out.println();

    // Print Pre-order traversal
    System.out.print("Pre-order Traversal: ");
    printPreOrder(root);
    System.out.println();

    // Print Post-order traversal
    System.out.print("Post-order Traversal: ");
    printPostOrder(root);
    System.out.println();
  }
}
