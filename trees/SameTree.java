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
        if(p == null && q == null) return true; // if both are the end nodes return true
        if(p == null && q != null) return false; // if one ended not another false
        if(p != null && q == null) return false; // same in reverse
         if(p.val != q.val) return false; // if all the above satisfies but the value itself is diff return false;

        boolean left = dfs(p.left, q.left); // go left all down first
        boolean right = dfs(p.right, q.right); // go right of the left

        return (left && right); // start calculation

    }
}