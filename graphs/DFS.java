/**
 * cracking the coding interview.
 * pseudocide for DFS
 */

void search(Node node){
    if(root == null) return;

    visit(node);
    root.visited = true;

    for(Node n : root.adjacent){
        if(n.visited == false){
            search(n);
        }
    }
}

