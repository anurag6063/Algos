
/*
[Note]
[Reference]: https://www.youtube.com/watch?v=BPlrALf1LDU&list=PLgUwDviBIf0rGEWe64KWas0Nryn7SCRWw
[Problem]: https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=detect-cycle-in-an-undirected-graph
[Pattern]: BFS ; store node + it's Parent; check it should have been visited only if it came from it's parent; IF NOT through as TRUE has a cycle.
[Tips]: 
[Revision]: 0
[Confidence]: 10%
[Next]: Practice 
[Steps]: 
[Code]	
	
[/Code]
[Tags]: 
[/Note]
*/


class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        
        boolean[] vis = new boolean[V];
        Arrays.fill(vis, false);
        
        for(int i = 0; i< V; i++){
            if(vis[i] == false){
                if(checkForCycle(i,vis, adj)){
                    return true;
                }
            }
        }
        
        return false;
}

    private static boolean checkForCycle(Integer s, boolean[] vis, ArrayList<ArrayList<Integer>> adj ){
        
    
        
        // Code here
        
        // start bfs + have a parent thing too.
        
        Queue<Map.Entry<Integer, Integer>> q = new  LinkedList<Map.Entry<Integer, Integer>>();
        q.add(new AbstractMap.SimpleEntry<>(s, -1));
        vis[s] = true;
        
        
        while(!q.isEmpty()){
            int parent = q.peek().getValue();
            int node = q.peek().getKey();
            
            q.remove();
            
            for(Integer it: adj.get(node)){
                if(vis[it] == false){
                    vis[it] = true;
                    q.add(new AbstractMap.SimpleEntry<>(it, node));
                }
                else if(parent != it){
                    // if already visited 
                    // it should have it's parent.
                    // if(parent == it) // this it would have been fine.
                    // if now
                    return true;
                    // if(parent != it) return true;
                }
            }
        
        
        }
        return false;
        
    }
}