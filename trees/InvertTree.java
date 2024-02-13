/*
[Note]
[Reference]: chatgpt
[Problem]: https://leetcode.com/problems/maximum-depth-of-binary-tree/
[Pattern]: Recursion, DFS
[Tips]: first go till the deep once i reach the depth, flip it. 
[Revision]: 1
[Confidence]: 40%
[Next]: Practice 
[Steps]: 
[Code]	
	
[/Code]
[Tags]: 
[/Note]
*/
/*
https://leetcode.com/problems/maximum-depth-of-binary-tree/
https://pega.udemy.com/course/blind-75-leetcode-questions-ace-algorithms-coding-interview/learn/lecture/37024936#overview

*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/** This is a divide and conqure problem. 
 * in Tree we have 
 * a) base case
 * b) call to itself
 * c) return based on something
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        return dfs(root);
    }

    public TreeNode dfs(TreeNode root){
        // base condition
        // go till max depth and then flip it starts
        if(root == null){
            return null;
        }
		// this makes it go to the extreme left depth 
        TreeNode left = dfs(root.left);
		// once it has gone to extreme left depth, it takes it right node
        TreeNode right = dfs(root.right);
        
        // when we get to the depth. 
        // for the root.left put the right node
        // for the root.left put the left node
		// and we flip it.
        root.left = right;
        root.right = left;

		// since the return type is TreeNode
        return root;
    }
}