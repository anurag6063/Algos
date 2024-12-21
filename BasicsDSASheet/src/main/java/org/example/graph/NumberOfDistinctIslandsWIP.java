/*
package BasicsDSASheet.src.main.java.org.example.graph;

*/
/*
# Algos
[Note]
[Reference]: https://www.youtube.com/watch?v=7zmgQSJghpo&list=PLgUwDviBIf0rGEWe64KWas0Nryn7SCRWw&index=9
[Problem]: https://www.geeksforgeeks.org/problems/number-of-distinct-islands/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=number-of-distinct-islands
[Pattern]: DFS + Component
[Tips]: Keep count of fresh tomatoes while looping
[Revision]: 0
[Confidence]: 10%
[Next]: Practice
[Steps]:
[Code]
Run for all components
created a visited matrix.
create a set of pair, this will store distinct visited route.
Get in only if it's not visited and also the grid has a valid entry point ie 1.

Once in, in Matirx  go around and do DFS (BFS).
Keep the data in path. But before keeping data substract the base starting point. This will make sure the pairs are exactly same in case of same path is followed.
return the path.

The calling function will put in the set of path.
return size of set as answer.


[/Code]
[Tags]:
[/Note]
*/

/*



import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class NumberOfDistinctIslandsWIP {


}


class Solution {

  int countDistinctIslands(int[][] grid) {
    // Your Code here
    int r = grid.length;
    int c = grid[0].length;

    boolean[][] vis = new vis[r][c];
    HashSet<ArrayList<String>> ans = new HashSet<>();
    List<String> route = new ArrayList<>();

    for(int i =0; i < r; i++){
      for(int j = 0; j < c; j++ ){
        if(!vis[i][j] && grid[i][j] == 1){
          dfs(grid, vis, route, i , j);
          ans.add(route);
        }
      }
    }

    return ans.size();
  }

  private static void dfs(int[][] grid,  boolean[][] vis, ArrayList<String> route ,
      int i , int j, int baseRow, baseCol){
    vis[i][j] = true;
    route.add(String.of(i - baseRow), String.value.of(baseCol - col));
    int r = grid.length;
    int c = grid[0].length;

    int[] rt = {0, 1, 0, -1};
    int[] ct = {1, 0, -1, 0};

    for(int x =0; x < 4 ; x++){
      int nr = i + rt[x];
      int nc = j + rc[x];

      if(nr > -1 && nr < r &&
          nc > -1 && nc < c &&
          grid[nr][nc] == 1 &&
          vis[nr][nc] == false){
        dfs(grid, vis, route, nr, nc, i)
      }
    }

  }
}



*/
