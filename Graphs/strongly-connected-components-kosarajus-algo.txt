/*
# Algos
[Note]
[Reference]:https://takeuforward.org/graph/strongly-connected-components-kosarajus-algorithm-g-54/
[Problem]: https://www.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=strongly-connected-components-kosarajus-algo
[Pattern]: DFS_Graph + stack for sequence + reverse
[Tips]: has 3 steps, find reversre sequence usinf stack, then reverse connection of graph, then do dfs on the reverse on till stack is empty
[Revision]: 0
[Confidence]: 10%
[Next]: Practice 
[Steps]: 
[Code]	
	
[/Code]
[Tags]: 
[/Note]
*/



class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        // find the sequence of nodes, using dfs , in reverse orvder , this will be the order of visit
        Stack<Integer> stack = new Stack<Integer>();
        boolean[] vis = new boolean[V];
        // dfs is self calling son need to define seperately
         for (int i = 0; i < V; i++) {
            if (vis[i] == false) {
                dfsStack(i, adj, stack, vis);
            }
        }
        
        
        // now i have my order
        // now reverse the links of the the graph 
        
        // adj stored the connection so i will have a reverse of it, so create a new adj list with reverse connection
        ArrayList<ArrayList<Integer>> adjReverse = new ArrayList<>();
        for(int i =0; i < V; i++){
            adjReverse.add(new ArrayList<Integer>());
        }
// #Note the way to reverse node connection in a directed graph. 
        for(int i =0; i< V; i++){
            vis[i] = false; // done so that i can reuse the vis list for next DFS
            for(Integer it: adj.get(i)){
                adjReverse.get(it).add(i);   
            }
        }
        
        // now find the count of strngly connected components - scc
        int scc = 0;
        while(!stack.isEmpty()){
            int node = stack.peek();
            stack.pop();
            if(vis[node] == false){
                scc++;
                dfs(node, vis, adjReverse);
            }
        }
        
        return scc;
    }
    
    private void dfs(int node, boolean[] vis,  ArrayList<ArrayList<Integer>> adjReverse ){
        vis[node] = true;
        
        for(Integer it: adjReverse.get(node)){
            if(!vis[it]){ // remmeber to use it here, else it will give incorrec answer.
                dfs(it, vis, adjReverse);
            }
        }
    }
    
    private void dfsStack(int node, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack, 
    boolean[] vis ){
        
        vis[node] = true;
        for(Integer it: adj.get(node)){
            if(!vis[it]){
                
                dfsStack(it, adj, stack, vis);
                
                // System.out.printf(" adding to stack %d \n", it);
            }
            
        }
// #Note: way to find the sequence of nodes in an graph.         
        // push to the stack after it has been processed compeletely
        stack.push(node);
    }
}

