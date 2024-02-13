/*
# Algos
[Note]
[Reference]: striver list tree
[Problem]: https://leetcode.com/problems/maximum-depth-of-binary-tree/
[Pattern]: recursion, dfs, add when needed
[Tips]: add +1 only to the max, or else even if i add to both and find the max it will work. just that we will do that operation unnecessarily. 
[Revision]: 2
[Confidence]: 70%
[Next]: Practice 
[Steps]: 
[Code]	
	
[/Code]
[Tags]: 
[/Note]
*/

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