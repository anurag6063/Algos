package BasicsDSASheet.src.main.java.org.example.bst;

import com.sun.source.tree.Tree;
import java.util.ArrayDeque;

public class MorrisTraversal {
  /*
  Intuition of the algo is: While going back o had to go to the root and then back to it right but in this case.
  We will use the pointer to go back automatically.
  * Need to go to a child, check if it has left,
  * if yes then create a link from the right most one to the parent.
  *
  * Now go to the left.
  *
  *
  * */
  public static void morrisTraversal(TreeNode root){
    if(root == null){
      return;
    }
    TreeNode curr = root;
    while(curr != null) {
      if (curr.left == null) {
        System.out.println(curr.val);
        curr = curr.right;
      } else {
        TreeNode left = curr.left;

        while(left.right != null && left.right != curr){
          left = left.right;
        }

        if(left.right == null){
          left.right = curr;
          curr = curr.left;
        }
        else {
          left.right = null;
          System.out.println(curr.val);
          curr = curr.right;
        }
      }
    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(0);
    root.left = new TreeNode(1);
    root.right = new TreeNode(2);

    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(4);

    root.right.left = new TreeNode(5);
    root.right.right = new TreeNode(6);

    morrisTraversal(root);
    System.out.println();
    inOrderTraversalUsingStack(root);
  }

  private static void inOrderTraversalUsingStack(TreeNode root){
    if(root == null){
      return;
    }
    TreeNode curr = root;
    ArrayDeque<TreeNode> stack = new ArrayDeque<>();

    while(curr != null || !stack.isEmpty()){

      while(curr != null){
        stack.push(curr);
        curr = curr.left;
      }

      curr = stack.pop();
      System.out.println(curr.val);

      curr = curr.right;

    }
  }

}
