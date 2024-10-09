package BasicsDSASheet.src.main.java.org.example.bst;

// Definition for a binary tree node with a 'next' pointer.
class Node {
  public int val;
  public Node left;
  public Node right;
  public Node next;

  public Node() {}

  public Node(int _val) {
    val = _val;
  }

  public Node(int _val, Node _left, Node _right, Node _next) {
    val = _val;
    left = _left;
    right = _right;
    next = _next;
  }
}

class Solution {
  public Node connect(Node root){
    // need to loop over the left most and that is the way.
    Node leftmost = root;
    while(leftmost.left != null){
      Node curr = leftmost;

      while(curr != null){ // this goes next - doing a BFS across tree itself.
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
}

public class PopulateNextPointer {
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

    Solution solution = new Solution();
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

