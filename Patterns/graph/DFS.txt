import java.util.ArrayList;

public class DFS {

  public static void main(String[] args) {

    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    for (int i = 0; i < 5; i++) {
      adj.add(new ArrayList<>());
    }

    System.out.println(adj.size());

    adj.get(0).add(2);
    adj.get(2).add(0);
    adj.get(0).add(3);
    adj.get(3).add(0);
    adj.get(0).add(1);
    adj.get(1).add(0);
    adj.get(2).add(4);
    adj.get(4).add(2);

    DFS dfs = new DFS();

    boolean[] vis = new boolean[5];

    dfs.doDFS(0, adj, vis);
  }

  private void doDFS(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {

    vis[node] = true;
    System.out.println("node " + node);

    for (Integer it : adj.get(node)) {
      if (!vis[it]) {
        doDFS(it, adj, vis);
      }
    }
  }
}
