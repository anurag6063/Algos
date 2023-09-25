/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */

class Solution {
    public int maxDepth(TreeNode root) {
      return dfs(root);
    }

    public int dfs(TreeNode root){

        // base case
        if(root == null){
            return 0;
        }

        // calulation intermediate
        int left = dfs(root.left);
        int right = dfs(root.right);

        // calulation while returning.
        return Math.max(left,right)+1;
    }
}