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
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightViewOfTree {

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.left.left = new Node(4);
    root.left.right = new Node(10);
    root.left.left.right = new Node(5);
    root.left.left.right.right = new Node(6);
    root.right = new Node(3);
    root.right.right = new Node(10);
    root.right.left = new Node(9);
    Node.printTree(root);

    RightViewOfTree rightViewOfTree = new RightViewOfTree();
//    rightViewOfTree.viewWrongDoesNotAccountLeftAlsoHavingLongerBranch(root);
    rightViewOfTree.view(root, 0, new ArrayList<>());
//    List<Integer> res = rightViewOfTree.viewLevelOrder(root);
//    res.forEach(System.out::println);

//    List<Integer> res2 = rightViewOfTree.viewLevelOrder(root);
//    res2.forEach(System.out::println);

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
