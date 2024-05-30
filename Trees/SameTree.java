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

// full code

public class Main{
    public static void main(String[] args){
        
        System.out.println("start");
        
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(3); // diff
        
        
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);
        
        
        Main main = new Main();
        System.out.println(main.sameTree(root, root2));
    }
    
    private boolean sameTree(TreeNode t1, TreeNode t2){
        
        // BC
        // when the tree is most basic check / single StackTraceElement
         
        if(t1 == null && t2 == null){
            
            return true;
        }
        
        System.out.println(t1.val + " : " + t2.val);
        
        if(t1 == null && t2 != null || t1 != null && t2 == null) 
        {
            System.out.println("mismatch");
            return false;
            
        }
      
        if(t1.val != t2.val){
            return false;
        }
        
        boolean left = sameTree(t1.left, t2.left) ;
        boolean right = sameTree(t1.right, t2.right);
        
        return left &&  right;
    }
    
    void inOrderSearch(TreeNode node){
        // start
        
        // BC 
        if(node == null){
            return;
        }
        
        // in order = left - mid - right 
        System.out.println("node: "+ node.val);
        inOrderSearch(node.left);
        inOrderSearch(node.right);
        
        
    }
}
  // Creating a simple binary tree
        //        1
        //       / \
        //      2   3
        //     / \
        //    4   5

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int val){
        this.val = val;
    }
}
