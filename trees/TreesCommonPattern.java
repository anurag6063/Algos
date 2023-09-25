class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p, q);
    }
    public boolean dfs(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val) return false;
        boolean left = dfs(root1.left, root2.left);
        boolean right = dfs(root1.right, root2.right);
        return left && right;
    }
} // TC: O(n), SC: O(n)

class Solution {
    public int maxDepth(TreeNode root) {
        return dfs(root);
    }
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        return 1 + Math.max(left, right);
    }
} // TC: O(n), SC: O(n)

class Solution {
    public TreeNode invertTree(TreeNode root) {
        return dfs(root);
    }
    public TreeNode dfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = dfs(root.left);
        TreeNode right = dfs(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
} // TC: O(n), SC: O(n)


class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }
    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int leftMax = Math.max(0, dfs(root.left));
        int rightMax = Math.max(0, dfs(root.right));
        max = Math.max(max, root.val + leftMax + rightMax);
        return root.val + Math.max(leftMax, rightMax);
    }
} // TC: O(n), SC: O(n)

class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (root.val == subRoot.val && isSame(root, subRoot)) {
            return true;
        }
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

class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode prev = null;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (prev != null && curr.val <= prev.val) {
                return false;
            }
            prev = curr;
            curr = curr.right;
        }
        return true;
    }
} // TC: O(n), SC: O(n)

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        while (true) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            k = k - 1;
            if (k == 0) return root.val;
            root = root.right;F
        }
    }
} // TC: O(n), SC: O(n)

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);
        while (root != null) {
            if (root.val > max) {
                root = root.left;
            } else if (root.val < min) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }
} // TC: O(h), SC: O(1)

class Solution {
    public int maxDepth(TreeNode root) {
        
        if(root == null)
            return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right)+ 1;

            
    }

 
}