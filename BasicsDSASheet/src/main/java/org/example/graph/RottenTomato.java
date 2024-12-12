package BasicsDSASheet.src.main.java.org.example.graph;
/*
# Algos
[Note]
[Reference]: https://www.youtube.com/watch?v=yf3oUhkvqA0&list=PLgUwDviBIf0rGEWe64KWas0Nryn7SCRWw&index=6
[Problem]: https://takeuforward.org/data-structure/rotten-oranges/
[Pattern]: BFS; Use Matrix rather than list; move with matrix than just visited
[Tips]: Keep count of fresh tomatoes while looping
[Revision]: 0
[Confidence]: 10%
[Next]: Practice
[Steps]:
[Code]

[/Code]
[Tags]:
[/Note]
*/

import java.util.LinkedList;
import java.util.Queue;


public class RottenTomato {

  public int rottenTomatoes(int[][] matrix) {
    int row = matrix.length;
    int col = matrix[0].length;

    Queue<Data> queue = new LinkedList<>();
    int[][] vis = new int[row][col];
    int fresh = 0;

    for(int i=0; i < row ; i++){
      for(int j =0; j < col; j++){
        if(matrix[i][j] == 2){
          queue.add(new Data(i,j,0));
          vis[i][j] = 2;
        }else {
          vis[i][j] = 0;
        }
        if(matrix[i][j] == 1){fresh++;}
      }
    }

    int time = 0;
    int[] drow = {-1, 0, +1, 0};
    int[] dcol = { 0, 1, 1 , -1};
    int count = 0;

    while(!queue.isEmpty()){
      int r = queue.peek().row;
      int c = queue.peek().col;
      int t = queue.peek().time;

      time = Math.max(time, t);
      queue.remove();

      for(int i =0; i< 4; i++){
        int nrow = r+drow[i];
        int ncol = c+dcol[i];
        if(nrow >=0 && nrow < row && ncol >=0 && ncol < col
        && vis[nrow][ncol] == 0 && matrix[nrow][ncol] == 1){
          queue.add(new Data(nrow,ncol,t+1));
          vis[nrow][ncol] = 2;
          count++;
        }
      }
    }

    if(count != fresh){
      return -1;
    }else{
      return count;
    }
  }

  public static void main(String[] args) {
    int[][] grid =  {{0,1,2},{0,1,2},{2,1,1}};

    RottenTomato obj = new RottenTomato();
    int ans = obj.rottenTomatoes(grid);
    System.out.println(ans);
  }

  public class Data{
    int row, col, time;
    public Data(int row, int col, int time){
      this.row = row;
      this.col = col;
      this.time = time;
    }
  }
}
