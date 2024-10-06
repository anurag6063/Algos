/*
# Algos
[Note]
[Reference]: https://www.youtube.com/watch?v=Yt50Jfbd8Po&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=16
[Problem]: https://leetcode.com/problems/balanced-binary-tree/
[Pattern]: recursion; find max depth ++ difference
[Tips]: Use max depth of BT solution add difference logic and a check of difference to find the answer. Have +1 only in the Max. In calculation 3 cases exist, if either L or R became -1 return -1 again, i2. If nwe diff b/w L and R has become > 1 return -1 else 2. return difeerence of L-% (abs). 
[Revision]: 1
[Confidence]: 50%
[Next]: Practice 
[Steps]: 
[Code]	
	
[/Code]
[Tags]: 
[/Note]
*/

// balanced tree can have diff b/w left and right node max as 1, 
// so i will try to mind the l and r node's height and then see it's difference.
class Solution {
    public boolean isBalanced(TreeNode root) {
        // here i am converting my int response to true or false. 
        // in he method call, i will force it to return -1 if the diff in height crosses 1
        return solve(root) == -1 ? false : true ;        
    }

    public int solve(TreeNode node){
        // when i reach the null node, the height is 0; the node just above me was the 1 st node.
        if(node == null) return 0;

        // it's a DFS search call. go to extreme left first then to it's right
        // while backtracting i will get my calculation done. Most code happens in backtracking
        int l = solve(node.left);
        int r = solve(node.right);
		
        // start extra code
        // Here i will have my 3 conditions.
        if(l == -1 || r == -1) return -1; // if already i know it became unbalanced
        if(Math.abs(r-l)>1) return -1; // if just not i calculate and found it's unbalanced; simple r-l no +1 here
		// end extra code
		
        // N: max of l/r +1 ; this is basic height of BT code.
        return Math.max(l,r)+1; // not yet unbalanced
    }
}