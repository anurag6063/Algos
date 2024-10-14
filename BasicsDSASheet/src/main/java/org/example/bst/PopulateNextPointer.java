package BasicsDSASheet.src.main.java.org.example.bst;

public class PopulateNextPointer {
    public Node connect(Node root){
      Node leftmost = root;
      while(leftmost.left != null){
        Node curr = leftmost;

        while (curr != null){
          curr.left.next = curr.right;
          if(curr.next != null){
            curr.right.next = curr.next.left;
          }
          curr = curr.next;
        }
        leftmost = leftmost.left;
      }
      return root;
    }


  public static void main(String[] args) {
    // Sample Example:
    // Constructing the following perfect binary tree:
    //           1
    //         /   \
    //        2     3
    //       / \   / \
    //      4   5 6   7

    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);

    PopulateNextPointer solution = new PopulateNextPointer();
    solution.connect(root);
    System.out.println("---");
//    solution.connect2(root);

    // After connection, the next pointers should be:
    // Node 1 -> null
    // Node 2 -> Node 3 -> null
    // Node 4 -> Node 5 -> Node 6 -> Node 7 -> null

    // Test: Print the next pointers for each level
    Node current = root;
    while (current != null) {
      Node levelNode = current;
      while (levelNode != null) {
        System.out.print(levelNode.val + " -> ");
        if (levelNode.next != null) {
          System.out.print(levelNode.next.val + " ");
        } else {
          System.out.print("null ");
        }
        levelNode = levelNode.next;
      }
      System.out.println();
      current = current.left;
    }
  }
}

