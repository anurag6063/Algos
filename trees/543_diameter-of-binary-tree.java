/*
# Algos
[Note]
[Reference]: https://www.youtube.com/watch?v=Rezetez59Nk&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=17
[Problem]: https://leetcode.com/problems/diameter-of-binary-tree/description/
[Pattern]: recursion, dfs, maxdepth ++ 
[Tips]: use dia[] to store referenced dai, done to know max depth of each side
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
    int maxDia = 0;
    public int diameterOfBinaryTree(TreeNode root) {
	
		// we need to use this since it will hold the max depth of each side. 
		// used dia[] to use this as reference
        int[] dia = new int[1];
        maxDia(root, dia);
        return dia[0];
    }

    private int maxDia(TreeNode node, int[] dia){
        if(node == null) return 0;

        int l = maxDia(node.left, dia);
        int r = maxDia(node.right, dia);

        dia[0] = Math.max(dia[0], l+r);

        return 1+Math.max(l,r);
    }
}