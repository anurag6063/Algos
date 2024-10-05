package org.example.bst;

public class MinimumValue {
  int minValue(Node root) {
    // code here

    if(root == null){
      return -1;
    }

    Node current = root;

    while(current.left != null){
      current = current.left;
    }
    return current.data;
  }

  // Function to find the minimum element in the given BST.
  // What i wrote; this did not use the BST property that at
  // any node the value in left tree will be less than the right one.
  int minValue2(Node root) {
    // code here
    return findMin(root);
  }

  static int findMin(Node node){
    if(node == null){
      return Integer.MAX_VALUE;
    }

    int left = findMin(node.left);
    int right = findMin(node.right);

    return Math.min(left, right);
  }

}
