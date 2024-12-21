//https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/solutions/5769332/100-beats-backtracking-java-explained/

package BasicsDSASheet.src.main.java.org.example.bst;
import BasicsDSASheet.src.main.java.org.example.TreeNode;
public class ConvertSortedArrayToBST {

  private TreeNode sortedArrayToBST(int[] arr) {
    if(arr == null || arr.length ==0){
      return null;
    }

    return buildBST(arr, 0 , arr.length -1);
  }

  private static TreeNode buildBST(int[] arr, int left, int right) {
    if(left > right){
      return null;
    }

    int mid = left + (right - left)/2;
    // create node
    TreeNode node = new TreeNode(arr[mid]);
    // create left and right
    node.left = buildBST(arr, left, mid-1);
    node.right = buildBST(arr, mid+1, right);

    return node;
  }

  public static void main(String[] args) {
    int[] arr = {1,2,3,4,5};
    TreeNode root = new ConvertSortedArrayToBST().sortedArrayToBST(arr);

    TreeNode.printInOrder(root);

  }
}


