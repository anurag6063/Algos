/*
# Algos
[Note]
[Reference]: https://www.youtube.com/watch?v=j1QDfU21iZk&list=PLgUwDviBIf0rGEWe64KWas0Nryn7SCRWw&index=30
[Problem]: https://takeuforward.org/data-structure/articulation-point-in-graph-g-56/
[Pattern]: DFS Fraph ++
[Tips]: 
[Revision]: 0
[Confidence]: 10%
[Next]: Practice and learn more on this,
[Steps]: 
[Code]	
	
[/Code]
[Tags]: 
[/Note]
*/



/*https://www.youtube.com/watch?v=j1QDfU21iZk&list=PLgUwDviBIf0rGEWe64KWas0Nryn7SCRWw&index=30

G-56. Articulation Point in Graph

1. use time of insertion during dfs
2. low[] minimum of time

*/


import java.io.*;
import java.util.*;

class Solution {
    private int timer = 1;
    private void dfs(int node, int parent, int[] vis,
                     int tin[], int low[], int[] mark,
                     ArrayList<ArrayList<Integer>> adj) {
       
       // visit the node
       vis[node] = 1;
       // isnantiate with time ie 1
       tin[node] = low[node] = timer;

       timer++; // 2
       int child = 0;
       for(Integer it: adj.get(node)){
        if(it == parent) continue;
        // if not visited
        if(vis[it] == 0){
            dfs(it, node, vis, tin, low, mark, adj);
            // once its back
            if(low[it] >= tin[node] && parent != -1){
                // mark the node as a articulation point
                mark[node] = 1;
            }
            child++;
        }else {
            low[node] = Math.min( low[node], tin[it]);
        }

        if(child > 1 && parent == -1){
            mark[node] = 1;
        }

       }

}
    //Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> articulationPoints(int n, ArrayList<ArrayList<Integer>> adj) {
       
       int[] vis = new int[n];
       int[] tin = new int[n];
       int[] low = new int[n];
        int[] mark = new int[n];

        // visit all the nodes starting from 0
        for(int i =0; i< n ; i++){
            if(vis[i] == 0){
                dfs(i, -1, vis, tin, low, mark, adj);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
    for(int i =0; i< n; i++){
        if(mark[i] == 1){
            ans.add(i);
        }
    }

    if(ans.size() == 0){
        ans.add(-1);
    }
    return ans;



    }
}



class Main {
    public static void main (String[] args) {
        int n = 5;
        int[][] edges = {
            {0, 1}, {1, 4},
            {2, 4}, {2, 3}, {3, 4}
        };
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < n; i++) {
            int u = edges[i][0], v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        Solution obj = new Solution();
        ArrayList<Integer> nodes = obj.articulationPoints(n, adj);

        int size = nodes.size();
        for (int i = 0; i < size; i++) {
            int node = nodes.get(i);
            System.out.print(node + " ");
        }
        System.out.println("");
    }
}
