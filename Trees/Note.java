/*
1. from main create a function ex. dfs 
2. pass to dfs whatever the main function got.
3. The base condtion: write the condition in which i will hit the bottom of DFS tree.
4. If the dfs needs to return int the base condition needs to return that base number.
5. I can have multiple base condition too. COnditional in nature. 
5. I can have extra processing that needs to be done apart from traversal. 
    that will be in middle.
6. the return will do some calculation and then return.
*/
//basic is to understand how to do this iteraction.

// this will mostly be true when there is one tree. 
// return value need to be Node type of object.
// any function name
// should take TreeNode type of object.

/*
class TreeNode{
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int val){
    this.val = val;
  }

}


public TreeNode dfs(TreeNode root){ 

    return root; // TreeNode
}

// for multiple trees generally return is true/false
public boolean dfs(TreeNode root1, TreeNode root2){

    return left && right; // boolean
}

// for single TreeNode
public TreeNode dfs(TreeNode root){
    // base condition 
    if(root == null){
        return null; // or return 0; for int return type.
    }
}

// for 2 trees kind.
public boolean dfs(TreeNode root1, TreeNode root2){
    // base condition
    // here we are checking both the nodes. 
    // return needs to be of return type. Thats based on the question.
    if(root1 == null && root2 == null) return true;
}


// The self call and the caluclation.
// this is the simplest way of doing a dfs. with resursion
public TreeNode dfs(TreeNode root){
    if(root == null){
        return null;
    }
     TreeNode left = root.left;
     TreeNode right = root.right;

     return root;
}


// doing additional calculation on the tree like max depth etc.


*/
