/*
# Algos
[Note]
[Reference]: 
[Problem]: https://leetcode.com/problems/same-tree/
[Pattern]: recursion
[Tips]: while going in itself check it, if a condtiton does not match return false, true is returned only if i reach p==null and q==null and return is left&&right.
[Revision]: 1
[Confidence]: 30%
[Next]: Practice 
[Steps]: 
[Code]	
	
[/Code]
[Tags]: 
[/Note]
*/

/**
 * https://leetcode.com/problems/same-tree/
 */

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p,q);
    }

    public boolean dfs(TreeNode p, TreeNode q){

        // when will it be same?
        // check the nodes for null
        // finally the values.
		// this is the base case; when both have reached null values and this time it will be true.
        if(p == null && q == null) return true; // if both are the end nodes return true
		
		// operation 
        if(p == null && q != null) return false; // if one ended not another false
        if(p != null && q == null) return false; // same in reverse
         if(p.val != q.val) return false; // if all the above satisfies but the value itself is diff return false;

		// self call
        boolean left = dfs(p.left, q.left); // go left all down first
        boolean right = dfs(p.right, q.right); // go right of the left

		// ans
        return (left && right); // start calculation

    }
}