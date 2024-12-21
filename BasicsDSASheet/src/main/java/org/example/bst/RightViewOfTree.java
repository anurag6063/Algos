/*
# Algos
[Note]
[Reference]: https://takeuforward.org/data-structure/right-left-view-of-binary-tree/
[Problem]: https://leetcode.com/problems/binary-tree-right-side-view/description/
[Pattern]: DFS using recursion, but with trick that level == res.size()
[Tips]: Smart check res.size() == level, maintain level variable to check if i am coming to this level for the first time.
[Revision]: 0
[Confidence]: 10%
[Next]: Practice
[Steps]:
[Code]

[/Code]
[Tags]: DFS Tree
[Intution]:
"""
Since i need a right view i need to find the first node towards the right.
I need to go till last. So maybe.
"""
[/Intution]
[QuestionNote]:
"""

"""
[QuestionNote]
[/Note]
*/

package BasicsDSASheet.src.main.java.org.example.bst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightViewOfTree {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(0);
    root.left = new TreeNode(1);
    root.right = new TreeNode(2);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(4);
    root.right.left = new TreeNode(5);
    root.right.right = new TreeNode(6);
    TreeNode.printTree(root);

    RightViewOfTree rightViewOfTree = new RightViewOfTree();
//    rightViewOfTree.viewWrongDoesNotAccountLeftAlsoHavingLongerBranch(root);
//    rightViewOfTree.view(root, 0, new ArrayList<>());
//    List<Integer> res = rightViewOfTree.viewLevelOrder(root);
//    res.forEach(System.out::println);

//    List<Integer> res2 = rightViewOfTree.viewLevelOrder(root);
//    res2.forEach(System.out::println);


//    List<Integer> ans = rightViewOfTree.rightViewSelf2(root);
//    ans.forEach(System.out::println);

    List<Integer> ans = rightViewDFS(root);
    System.out.println();
    ans.forEach(System.out::print);
  }

  private static List<Integer> rightViewDFS(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    if(root == null) {
      return  ans;
    }
    HashMap<Integer, Integer> map = new HashMap<>();
    rightViewSelfDF(root, ans, map, 0);
    return ans;
  }

  private static void rightViewSelfDF(TreeNode node, List<Integer> ans,
      HashMap<Integer, Integer> map, int level){
    if(node == null){
      return;
    }
    if(!map.containsKey(level)){
      map.put(level, node.val);
      ans.add(node.val);
    }
    System.out.println(node.val);
    rightViewSelfDF(node.right, ans, map, level+1);
    rightViewSelfDF(node.left, ans, map, level+1);


  }
  private static List<Integer> rightViewSelf2(TreeNode node){
    List<Integer> ans = new ArrayList<>();

    if(node == null){
      return ans;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    // setup
    queue.add(node);

    while(!queue.isEmpty()){
      // find elements initially and loop over them
      int size = queue.size();

      for(int i = 0; i < size; i++){
        TreeNode curr = queue.poll();
        if(i == size-1){
          ans.add(curr.val);
        }

        if(curr.right != null){
          queue.add(curr.left);
        }
        if(curr.left != null){
          queue.add(curr.right);
        }
      }
    }
    return ans;
  }

  private static void rightViewSelf(TreeNode node){
    if(node == null){
      return;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(node);

    while(!queue.isEmpty()){
      queue.forEach(x -> System.out.print(x.val));
      System.out.println();
      int size = queue.size();
      for(int i =0; i < size; i++){

        TreeNode curr = queue.poll();
        if(size-1 == i){
          System.out.println("Found "+curr.val);
        }
        if(curr.left != null){
          queue.offer(curr.left);
        }
        if(curr.right != null){
          queue.offer(curr.right);
        }
      }
    }
  }



  private void view(Node node, int level, List<Integer> ans) {
    if(node == null) {
      return;
    }
    if(level == ans.size()){
      // so the first time i reach a level and i see a node i will add to the ans
      ans.add(node.val);
      System.out.println(node.val);

      // since i need right view i will first look right
      view(node.right, level+1, ans);
      view(node.left, level+1, ans);
    }
  }

  private List<Integer> viewLevelOrder(Node node){
    List<Integer> list = new ArrayList<>();
    if(node == null){
      return list;
    }

    Queue<Node> queue = new LinkedList<>();
    queue.add(node); // add the first node

    while(!queue.isEmpty()){
      int elementsInQueue = queue.size();

      for(int i =0; i < elementsInQueue; i++){  // looping over all the elements in queue when i entered this.
        // ie the previous level
        Node curr = queue.poll();

        if(elementsInQueue - 1 == i){
          list.add(curr.val);
        }

        if(curr.left != null){
          queue.add(curr.left);
        }
        if(curr.right != null){
          queue.add(curr.right);
        }
      }
    }
    return list;
  }

  private List<Integer> viewLevelOrderFromRHS(Node node){
    List<Integer> list = new ArrayList<>();
    if(node == null){
      return list;
    }

    Queue<Node> queue = new LinkedList<>();
    queue.add(node); // add the first node

    while(!queue.isEmpty()){
      int elementsInQueue = queue.size();

      for(int i =0; i < elementsInQueue; i++){  // looping over all the elements in queue when i entered this.
        // ie the previous level
        Node curr = queue.poll();

        if(1 == i){
          list.add(curr.val);
        }

        if(curr.right != null){
          queue.add(curr.right);
        }
        if(curr.left != null){
          queue.add(curr.left);
        }
      }
    }
    return list;
  }

  // this code will leave a branch that i longer and not part of original right.
  // 101 got missed here
  private void viewWrongDoesNotAccountLeftAlsoHavingLongerBranch(TreeNode node) {
    while (node != null) {
      System.out.println(node.val);

      if(node.right != null){
        node = node.right;
      } else if (node.left != null) {
        node = node.left;
      }
      if(node.left == null && node.right == null){
        System.out.println(node.val);
        break;
      }
    }
  }
}
