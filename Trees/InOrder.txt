/*
[Note]
[Reference]: own
[Problem]: 
[Pattern]: recursion
[Tips]: do till node == null; and go left and right, going means calling itself and since its not returning anything, no need to handle anything.
[Revision]: 2
[Confidence]: 80%
[Next]: Practice 
[Steps]: 
[Code]	
	
[/Code]
[Tags]: 
[/Note]
*/
// In-order traversal means to "visit" (often, print) the left branch, then the current node, and finally, the right
// branch.

/*
void inOrderTraversal(TreeNode node) {
     if (node!= null) {
     inOrderTraversal(node.left);
     visit(node);
     inOrderTraversal(node.right);
     }
}

// When performed on a binary search tree, it visits the nodes in ascending order (hence the name "in-order"). 
// since we had to just return void the whole recursive function has been put in if 

// full code
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int val){
        this.val = val;
    }
    
}


public class InOrderTraversal
{
	public static void main(String[] args) {
		System.out.println("Start--");
		
		 //        1
        //       / \
        //      2   3
        //     / \
        //    4   5
        
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        
        InOrderTraversal main = new InOrderTraversal();
        main.inOrderTraversal(root);
	}
	
	public void inOrderTraversal(TreeNode node){
	    // BC
	    if(node == null){
	        return;
	    }
	    // left - mid - right 
	    inOrderTraversal(node.left);
	    System.out.println( node.val + " : m:");
	    inOrderTraversal(node.right);
	    // Output should be: 4 2 5 1 3
	}
}

*/
