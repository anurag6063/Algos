/*
# Algos
[Note]
[Reference]: https://www.youtube.com/watch?v=qrAub5z8FeA&list=PLgUwDviBIf0rGEWe64KWas0Nryn7SCRWw&index=29
    [Problem]: https://leetcode.com/problems/critical-connections-in-a-network/description/
[Pattern]: DFS_Graph + time of inserting and lowest
[Tips]: needs additional time of visit and lowest time array. 
[Revision]: 0
[Confidence]: 10%
[Next]: Practice 
[Steps]: need to slip parent; while coming back and going in check low[node] as min, while coming out of DFS check if bridge can be exist in this connection. without breaking 
[Code]	
	
[/Code]
[Tags]: 
[Intution]: 
"""
Also known as Tarjan's strongly connected components algorithm.

1. Timer is used to know the time at which each node was visited. It's the time keeper. The timer can then later help me to find 
how deep one branch can go. 
2. Initially for each not low is the timer value itself. 
3. Lowest depth, means the smallest/closet distance from the root/starting point/
4. So here I need to find the lowest depth of a node. Is the minimum value of timer of all the component that it's connected to
So the lowest can be found when I can come back/ backtracking.  when I have just visited or else when I have already seen the node,
but maybe while doing other operations the timer value could have changed. 
Timer value is just used just for comparision ( low[it] > toi[node])
low is initially equal to timer and then it's mutated while backtracking and if the IT (connected node) is already seen. 
the low is recalculated as Math.min(low[node], low[it]);
"""

[/Note]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 *
 *
 * 
 * There are n servers numbered from 0 to n - 1 connected by undirected server-to-server connections forming a network
  where connections[i] = [ai, bi] represents a connection between servers ai and bi. Any server can reach other servers
  directly or indirectly through the network.
A critical connection is a connection that, if removed, will make some servers unable to reach some other server.
Return all critical connections in the network in any order.
 */

class CriticalConnectionsInANetwork {
    // global, since all the dfs calls need to get this and it always increases.
    // #Note: to maintain the time of visit of each node in DFS; use a class variable time ;  int timer = 1;
    int timer = 1;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        // the adj list is not given and i need it.
        // convert to adj 
        // it has given connection point like 1 --> 2, 2-->1 so i need to get both the value and convert to adj list

// #Note: convert a connection to a adj list, first create all the array inside and then only add the values

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        // create a space and then add in next for loop
        for(int i =0; i < n ; i++){
            adj.add(new ArrayList<>());
        }

        for(List<Integer> it: connections){
            int u = it.get(0);
            int v = it.get(1);
            // get the uth index and add v to it so at U intex it will have add the adjecents
            // bi directional
            adj.get(u).add(v);
            adj.get(v).add(u);
            System.out.printf(" u %d , v %d \n", u, v);

        }

        // now all the things are set, we can start
        // timeOfInsertion = toi 
        // visited array = vis
        // lowest time of visit = low
        int[] toi = new int[n];
        int[] vis = new int[n];
        int[] low = new int[n];

        List<List<Integer>> ans = new ArrayList<>();
        // no need of component , just start

        // start, parent  + every other container that i have top to bottom
        dfs( 0, -1, adj, toi, vis, low, ans);

        return ans;
    }

    private void dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj,
    int[] toi, int[] vis , int[] low, List<List<Integer>> ans){
         System.out.printf("time %d , node %d \n", timer, node);
        // do DFS ++
        // set default values
        vis[node] = 1;
        // as i remember when i was doing the DFS IN - i was having timer values for both low ad toi
        toi[node] = low[node] = timer;
        // setting for next dfs call
        timer++;
       
        for(Integer it: adj.get(node)){
            
            // for this comparison I am carrying the parent
            if( it == parent ) continue;
            if(vis[it] == 0){ // while going in 
                // dfs has not been performed, so do it
                dfs(it, node, adj, toi, vis, low, ans); // this is common in if and else
                // once it comes back
                low[node] = Math.min(low[node], low[it]);  

                // check if it is a bridge
                if(low[it] > toi[node]){
                    ans.add(Arrays.asList(it, node));
                    System.out.printf("added as bridge %d %d \n", it, node);
                } 
            }else{ // while backtracking
                low[node] = Math.min(low[node], low[it]); // this is common in if and else
                System.out.printf("while backtracking node %d\n", node);
            }
        }

    }
}