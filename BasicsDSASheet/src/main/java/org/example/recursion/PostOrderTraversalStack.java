package BasicsDSASheet.src.main.java.org.example.recursion;

import java.util.*;
class Node{
  int data;
  Node left, right;

  Node(int data){
    left = right = null;
  }
}

public class PostOrderTraversalStack {

  public static void postOrderTraversal(Node root){
    if(root == null){
      return;
    }

    ArrayDeque<Node> stack = new ArrayDeque<>();
    Node curr = root;
    Node last = null;

    while(!stack.isEmpty() || curr != null){
      if(curr != null){
        stack.push(root);
        curr = curr.left;
      }else {
        Node peekNode = stack.peek();
        if(peekNode.right != null && last != peekNode.right){
          curr = peekNode.right;
        }else {
//          arr
        }
      }
    }
  }
  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);

    root.left.left = new Node(5);
    root.left.right = new Node(6);

    root.right.left = new Node(7);
    root.right.right = new Node(8);
  }
}
