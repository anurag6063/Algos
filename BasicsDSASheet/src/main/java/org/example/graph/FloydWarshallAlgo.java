package BasicsDSASheet.src.main.java.org.example.graph;

public class FloydWarshallAlgo {

  public void practice(int[][] data){
    int n = data.length;
    for(int i =0; i < n ; i++){
      for(int j =0; j < n ; j++){
        if(data[i][j] == -1){
          data[i][j] = (int) (1e9);
        }
        if(i == j ){
          data[i][j] = 0; // this wil fill diagonal data/
        }
      }
    }

    for(int k =0; k < n ; k++){
      for(int i =0; i < n ; i++){
        for(int j =0; j < n; j++){
          data[i][j] = Math.min(data[i][j], data[i][k]+ data[k][j]);
        }
      }
    }

    for(int i =0; i < n ; i++){
      for(int j =0; j < n ;j++){
        if(data[i][j] == (int)1e9){
          data[i][j] = -1;
        }
      }
    }
  }
  public void shortest_distance(int[][] matrix) {
    int n = matrix.length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == -1) {
          matrix[i][j] = (int)(1e9);
        }
        if (i == j) matrix[i][j] = 0;
      }
    }

    for (int k = 0; k < n; k++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          matrix[i][j] = Math.min(matrix[i][j],
              matrix[i][k] + matrix[k][j]);
        }
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == (int)(1e9)) {
          matrix[i][j] = -1;
        }
      }
    }
  }

  public static void main(String[] args) {
    int V = 4;
    int[][] matrix = new int[V][V];

    for (int i = 0; i < V; i++) {
      for (int j = 0; j < V; j++) {
        matrix[i][j] = -1;
      }
    }

    matrix[0][1] = 2;
    matrix[1][0] = 1;
    matrix[1][2] = 3;
    matrix[3][0] = 3;
    matrix[3][1] = 5;
    matrix[3][2] = 4;

    FloydWarshallAlgo obj = new FloydWarshallAlgo();
    obj.shortest_distance(matrix);

    for (int i = 0; i < V; i++) {
      for (int j = 0; j < V; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println("");
    }
  }
}