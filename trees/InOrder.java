// In-order traversal means to "visit" (often, print) the left branch, then the current node, and finally, the right
// branch.
void inOrderTraversal(TreeNode node) {
     if (node!= null) {
     inOrderTraversal(node.left);
     visit(node);
     inOrderTraversal(node.right);
     }
7 }

// When performed on a binary search tree, it visits the nodes in ascending order (hence the name "in-order"). 
// since we had to just return void the whole recursive function has been put in if 