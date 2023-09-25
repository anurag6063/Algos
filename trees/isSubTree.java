
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // if root then it can never have a sub tree
        if (root == null) return false;
        // now lets check when it can be.
        // when both the values match. and the tree in root and the subroot is same/identical.
        if (root.val == subRoot.val && isSame(root, subRoot)) {
            return true;
        }
        // keep calling left , the subroot remains same beause the subroot
        // remains constant while we navigate the main tree. 

        // we navigate the sub tree only when we know the root.val and subtree.val is same.
        // when we get that same, we compare the real tree of both.
        boolean left = isSubtree(root.left, subRoot);
        boolean right = isSubtree(root.right, subRoot);
        return left || right;
    }
    public boolean isSame(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val) return false;

        boolean left = isSame(root1.left, root2.left);
        boolean right = isSame(root1.right, root2.right);
        return left && right;
    }
} // TC: O(m * n), SC: O(m)