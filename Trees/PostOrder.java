/*
[Note]
[Reference]: own
[Problem]: 
[Pattern]: recursion
[Tips]: do till node == null; and go right and left then print, going means calling itself and since its not returning anything, no need to handle anything.
[Revision]: 2
[Confidence]: 80%
[Next]: Practice 
[Steps]: 
[Code]	
	
[/Code]
[Tags]: 
[/Note]
*/
// Post-order traversal visits the current node after its child nodes (hence the name "post order"). 
// In a post-order traversal, the root is always the last node visited. 

void postOrderTraversal(treeNode node){
    if(node != null){
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        print(node.val);
    }
}
