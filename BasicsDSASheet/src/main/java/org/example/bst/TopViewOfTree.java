/*
package BasicsDSASheet.src.main.java.org.example.bst;

public class TopViewOfTree {

}


class Solution {
  // Function to return a list of nodes visible from the top view
  // from left to right in Binary Tree.
  static ArrayList<Integer> topView(Node root) {
    ArrayList<Integer> ans = new ArrayList<Integer>();
    // add your code
    if(root == null){
      return ans;
    }
    findLeftOne(root.left, ans);
    ans.add(root.data);
    findRightOne(root.right, ans);
    return ans;
  }

  private static void findLeftOne(Node node, ArrayList<Integer> ans){
    if(node == null){
      return;
    }

    if(node.left != null){
      findLeftOne(node.left, ans);
    }

    ans.add(node.data);
  }

  private static void findRightOne(Node node, ArrayList<Integer> ans){
    if(node == null){
      return;
    }

    if(node.right != null){
      findRightOne(node.right, ans);
    }

    ans.add(node.data);
  }
}

//---


class Solution {
  // Function to return a list of nodes visible from the top view
  // from left to right in Binary Tree.
  static ArrayList<Integer> topView(Node root) {
    // add your code
    PriorityQueue<Pair<Integer , Integer> ans = new PriorityQueue<Pair<Integer , Integer>();

    // do Level OT, and push values as per index.
    ans = traversal(root)

  }

  private static PriorityQueue<Pair<Integer , Integer> traversal(TreeNode node){
    Queue q = new ArrrayDeque<Pair<Integer, Integer>();

    q.add(node);

    while(!q.isEmpty()){
      int s = q.size();

      for(int i =0; i < s ; i++){
        q.add()
      }
    }
  }
}
*/
