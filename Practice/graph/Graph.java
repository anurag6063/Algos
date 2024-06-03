
package Algos.Patterns;
// /workspaces/Algos/Patterns/Practice.java
// DFS graph 

/*
 * i need to do divide and conqure 
 * will use a self recursion call. 
 * 
 * outside it need to have a boolean visited array 
 * will just put the answer in a araay and return 
 * 
 * creation .. adjacency list is needed. 
 * 
 * index is the start and the connected to all one is in the RHS 
 * 
 */

import java.util.*;
import java.util.HashMap;
import java.util.Map;

class Graph {

    private Map<Integer, List<Integer>> graph;

    Graph(){
        graph = new HashMap<>();
    }

    private void addEdge(int node1, int node2){
        graph.putIfAbsent(node1, new ArrayList<>());
        graph.putIfAbsent(node2, new ArrayList<>());

        graph.get(node1).add(node2);
        graph.get(node2).add(node1);
    }

    private List<Integer> getConnections(int node){
        return graph.getOrDefault(node, new ArrayList<Integer>());
    }

    private void printGraph(){
     
    }

    public static void main(String[] args){

        createAGraph();
    }

    private static void createAGraph(){


        // o -> 1
        // 1 -> 0 

        // then change to adj list

        Graph graph = new Graph();
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);

        graph.dfsSetup(0);
    }

    private  void dfsSetup(int node){

        boolean[] vis = new boolean[5];
        Arrays.fill(vis, false);
        ArrayList<Integer> ans = new ArrayList<Integer>();
        dfs(graph, vis, -1 , node , ans);

    }

    private void dfs(Map<Integer, List<Integer>> graph, boolean[] vis, int parent, int node , ArrayList<Integer> ans){

        vis[node] = true;
        ans.add(node);
        System.out.println(node);

        for(int it: getConnections(node)){
            
            if(!vis[it]){
                dfs(graph, vis, node, it, ans);
            }
        }


    }
}