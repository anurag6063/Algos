/*
question: "https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/"
problemStatement: |
    At each level change the traversal from L - R to R - L, so the queue is not sufficeint
    Need to use a way that the same queue need to behave as stack as well as queue.
intuition: |
    Took inspiration from normal BFS.
    To find at each level the direction of traversal. Use level no. This is done as level % 2

    Next use a ArrayDeque.
    Use pollFirst and pushLast for making it behave like a queue.
    Use pollLast and pushFirst to make it work like a stack.

diagram: "https://app.diagrams.net/#G1wQGlG18ATtU99-7HZ7PYAULiXhsPoZnd#%7B%22pageId%22%3A%22W4fxuu8yu22NCt1HPZ5b%22%7D"
pattern: ["level order traversal"]
solutionReference: ""
confidence: ""
*/

package BasicsDSASheet.src.main.java.org.example.bst;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class ZigZagTraversal {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if(root == null){
      return result;
    }

    // level order traversal.
    ArrayDeque<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    int level = 0;

    while(!queue.isEmpty()){
      int size = queue.size();
      ArrayList<Integer> ans = new ArrayList<>();
      if(level % 2 == 0){
        // then left to right; use queue behaviour
        for(int i =0 ; i < size ; i++){
          TreeNode temp = queue.pollFirst();
          if(temp.left != null){
            queue.add(temp.left);
          }
          if(temp.right != null){
            queue.add(temp.right);
          }


          ans.add(temp.val);
          System.out.println(" adding evens ");
        }
      }else{
        for(int i =0 ; i < size; i++){
          TreeNode temp = queue.pollLast();
          if(temp.right != null){
            queue.offerFirst(temp.right);
          }

          if(temp.left != null){
            queue.offerFirst(temp.left);
          }

          ans.add(temp.val);
          System.out.println(" adding odds " + temp.val) ;
        }
      }
      result.add(ans);
      level++;
    }
    return result;
  }
}


