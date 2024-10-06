// Pre-order traversal visits the current node before its child nodes (hence the name "pre-order").
// In a pre-order traversal, the root is always the first node visited. 


void preOrderTraversal(TreeNode node){
    if(node != null){
        print(node.val);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
}