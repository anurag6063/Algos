/*
[Note]
[Reference]: https://www.youtube.com/watch?v=-tgVpUgsQ5k&list=PLgUwDviBIf0rGEWe64KWas0Nryn7SCRWw&index=4
[Problem]: https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=bfs_of_graph
[Pattern]: Modify links of LL
[Tips]: BFS uses queue
[Revision]: 2
[Confidence]: 80%
[Next]: Practice 
[Steps]: Create a queue; mark root as true, put root into the queue; while there are elements in queue, remove the element and visit it. Now since we have to go deeper have a for loop that finds all the sub nodes and if they are not visited; mark them as visited and queues it.
[Code]	

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


    
        // bfs always needs a quque, since it has to process nodes in a level wise order.
        // in bidirectional graph we always need a visited array since we may repeat ourselves and get stuck in a loop
        // in a graph algo if i exceed time, check for visited == false while going ahead, this may have started a infinite loop. 

class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        // my container 
        // get me the space and DS
        ArrayList<Integer> ans = new ArrayList<>();
        boolean vis[] = new boolean[V]; // V is no of nodes
        Queue<Integer> q = new LinkedList<>();
        
        // initlaize the variable / the space
        // start with 0, the 0th node
        q.add(0);
        vis[0]= true;
        
        // everyone needs to pass through the  queue in a level fashion
        while(!q.isEmpty()){

            // what if there was single node
            // lets get out the parent node and put it in
            Integer node = q.poll();
            ans.add(node);
            
            // remove and then fill it;s children so that the next iteration of while loop can tc of it
            // till all children are processed 
            for(Integer i : adj.get(node)){
                // if not visited
                // get all it's children and put in queue and always mark their visited also as true                
                if(vis[i] == false){
                    vis[i] = true;
                    q.add(i);
                }
            }
        }
        
        return ans;
        
        
    }
}

// ----


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