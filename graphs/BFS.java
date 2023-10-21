/**
 * This cannot be implemented using recursive function.
 * It always uses a queue.
 * Iterative function using a queue works best
 * 
 * 
 */




void search(Node root){
    Queue queue = new Queue();
    root.marked = true;
    queue.enqueue(root); // add to the end

    while(!queue.isEmpty()){

        Node r = queue.dequeue() // remove from the front
        visit(r);
        for(Node n: r.adjecency){
            if(n.marked == false){
                n.marked = true;
                queue.enqueue(n);
            }
        }
    }

}










/**
 * 	https://takeuforward.org/graph/breadth-first-search-bfs-level-order-traversal/	BFS code
	https://www.youtube.com/watch?v=Qzf1a--rhp8	video explanation for BFS. Use queue and adjecency DS.
    
 */