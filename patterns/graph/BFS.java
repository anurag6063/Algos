package patterns.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

  // components
  // adjacency list - connection is described here.
  // use queue
  // boolean array to visited nodes

  public static void main(String[] args) {

    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    // created empty array list
    for (int i = 0; i < 5; i++) {
      adj.add(new ArrayList<>());
    }

    // now fill values.
    // added pointers in both the directions.
    // if 1 to 0 than 0 to 1 is also present.
    // this mapping describes the links bewtween the nodes.
    adj.get(0).add(1);
    adj.get(1).add(0);
    adj.get(0).add(4);
    adj.get(4).add(0);
    adj.get(1).add(2);
    adj.get(2).add(1);
    adj.get(1).add(3);
    adj.get(3).add(1);

    BFS bfsClass = new BFS();
    ArrayList<Integer> ans = bfsClass.bfs(5, adj);

    System.out.println("nodes: " + ans);
  }


  private ArrayList<Integer> bfss(Integer size, ArrayList<ArrayList<Integer>> adj) {

    System.out.println();
    System.out.println(" here --");
    // bfs using queue
    // init
    ArrayList<Integer> ans = new ArrayList<>();
    Queue<Integer> queue = new LinkedList<>();
    boolean[] visited = new boolean[size];

    // pre process
    processElement(0, queue, visited);

    while (!queue.isEmpty()) {

      // process what's in hand
      Integer node = queue.poll();
      ans.add(node);

      for (Integer it : adj.get(node)) {
        if (!visited[it]) {
          processElement(it, queue, visited);
        }
      }
    }

    return ans;
  }

  private static void processElement(int node, Queue<Integer> queue, boolean[] visited) {
    queue.add(node);
    visited[node] = true;

    System.out.println(visited[node] + " : " + queue.peek());
  }

  private ArrayList<Integer> bfsPrac(int size, ArrayList<ArrayList<Integer>> adj) {

    // setup and initialization
    ArrayList<Integer> ans = new ArrayList<>();
    boolean[] visited = new boolean[size];
    Queue<Integer> queue = new LinkedList<>();

    // pre start
    queue.add(0); // set the starting point.
    visited[0] = true; // visit it

    // process
    while (!queue.isEmpty()) {
      Integer node = queue.poll();
      ans.add(node);

      for (Integer it : adj.get(node)) {
        if (!visited[it]) {
          visited[it] = true;
          queue.add(it);
        }
      }
    }

    // post

    return ans;
  }

}
