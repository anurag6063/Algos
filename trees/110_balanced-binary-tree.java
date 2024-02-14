/*
# Algos
[Note]
[Reference]: https://www.youtube.com/watch?v=Yt50Jfbd8Po&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=16
[Problem]: https://leetcode.com/problems/balanced-binary-tree/
[Pattern]: recursion; find max depth ++ difference
[Tips]: Use max depth of BT solution add difference logic and a check of difference to find the answer. Have +1 only in the Max . 
[Revision]: 0
[Confidence]: 30%
[Next]: Practice 
[Steps]: 
[Code]	
	
[/Code]
[Tags]: 
[/Note]
*/

class Solution {
    public boolean isBalanced(TreeNode root) {
        return solve(root) == -1 ? false : true ;        
    }

    public int solve(TreeNode node){
        if(node == null) return 0;

        int l = solve(node.left);
        int r = solve(node.right);
		// start extra code
        if(l == -1 || r == -1) return -1;
        if(Math.abs(r-l)>1) return -1;
		// end extra code
		
        return Math.max(l,r)+1;
    }
}