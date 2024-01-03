/*
[Note]
[Reference]: 
[Problem]:
[Pattern]: Modify links of LL
[Tips]: BFS uses queue
[Revision]: 0
[Confidence]: 10%
[Next]: Practice 
[Steps]: Create a queue; mark root as true, put root into the queue; while there are elements in queue, remove the element and visit it. Now since we have to go deeper have a for loop that finds all the sub nodes and if they are not visited; mark them as visited and queues it.
[Code]	

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

[/Code]
[/Note]
*/

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