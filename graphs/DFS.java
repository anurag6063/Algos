/*
[Note]
[Reference]: CCI Book
[Problem]: NA
[Pattern]: DFS ; recursion, base case and for loop to go deep
[Tips]: Use recursion and keep marking when you see one. 
[Revision]: 0
[Confidence]: 10%
[Next]: Practice 
[Steps]: Base case is root == null; visit the node and mark it as visited,then use for loop to go in. Check if not visited do a search ( call itself)
[Code]	
	
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
[/Code]
[/Note]
*/
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

