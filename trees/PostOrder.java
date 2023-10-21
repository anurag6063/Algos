// Post-order traversal visits the current node after its child nodes (hence the name "post order"). 
// In a post-order traversal, the root is always the last node visited. 

void postOrderTraversal(treeNode node){
    if(node != null){
        postOrderTraversal(node.left);
        postOrderTraversal(right);
        print(node.val);
    }
}
