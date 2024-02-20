/*
[Note]
[Reference]: CCI Book ; https://www.youtube.com/watch?v=Qzf1a--rhp8&list=PLgUwDviBIf0rGEWe64KWas0Nryn7SCRWw&index=6
[Problem]: https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=dfs_of_graph
[Pattern]: DFS ; recursion, base case and for loop to go deep
[Tips]: Use recursion and keep marking when you see one. 
[Revision]: 1
[Confidence]: 70%
[Next]: Practice 
[Steps]: Base case is root == null; visit the node and mark it as visited,then use for loop to go in. Check if not visited do a search ( call itself)
[Code]	

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


// algo from take u forward
// remember in this DFS allgo the top node will come first in the ans list, then the bottom, this is unlike in tree.
// but in tree i had direction so there is no sense of direction here as which one is top and bottom. Cool :) 

class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    // V is no of nodes it has; i have List os List since if i declare a single List it can hold only one item in each of it's element
    // here i need to store a list of items in a array position so List of List.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        ArrayList<Integer> ans = new ArrayList<>();

        // in graph i always need a visted array, not to repeat node
        // boolean[] vis = new boolean[V+1];
        boolean[] vis = new boolean[V]; // can work
        
        // initlaize 
        // vis[0]= true; // not needed for sure
        
        // start the algo 
        // dfs needs a stack - recursion
        // starting node is 0
        dfs(0, vis, adj, ans );
        // the ans by DFS algo will be given in LS
        return ans;
        
    }
    
    private static void dfs( int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans ){
                
        // what do i do at a single node
        // 1. i mark it as visted
        // 2. add the current received node to answer
        // 3. i find all it's children ans start isting them IF NOT VISITED
        
        // mark as visited, with help of node no
        vis[node] = true;
        ans.add(node);
        
        for(Integer it: adj.get(node)){
            if(vis[it] == false){
                dfs(it, vis, adj, ans);
            }
        }
        
        
    }
}