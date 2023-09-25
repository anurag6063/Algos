/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 */
    
    public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        // base condition and if we just have the root as null that too is a valid BST.
        if (root == null) return true;
        System.out.println("root "+ root.val + " max "+ maxVal + " "+ minVal);

        

        // navigate the left and right
        boolean left = isValidBST(root.left, minVal, root.val);
        boolean right = isValidBST(root.right, root.val, maxVal);

        // if root has value, it needs to be in range b/w it's left and right children.
        if (root.val >= maxVal || root.val <= minVal) return false;
        
        // check condition and return 
        return left && right;
    }
}
