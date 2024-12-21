package BasicsDSASheet.src.main.java.org.example.recursion;

public class WordSearch {

  public static void main(String[] args) {
    // Input data
    char[][] board = {
        {'A', 'B', 'C', 'E'},
        {'S', 'F', 'C', 'S'},
        {'A', 'D', 'E', 'E'}
    };
    String word = "ABCCED";

    // Instantiate WordSearch and check for the word
    WordSearch ws = new WordSearch();
    boolean result = ws.exist(board, word);

    // Output the result
    System.out.println("Does the word exist in the board? " + result);
  }

  public boolean exist(char[][] board, String word) {
    // board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"

    // The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

    // so at any location to form the work i if a value in present to it's right and down and it cannot be used more than once.
    // this was i can find all the combination of words that can be formed and at the base case. I can check if the formed word is the given word. If any one says true, then return yes else false.

    // No but what about SEE.
    // So better approach is to go through each letter. if the first word matches. try to find if i get the next word on it's left, right , top or bottom. If yes use that and mark it as used. Then from that check again.

    // If i do not find, come back and try another option; and unmark the loactions.

    char[] letters = word.toCharArray();
    System.out.println(board.length + " " + board[0].length);
    for(int i = 0; i < board.length; i++){
      System.out.println(i);
      for(int j = 0; j < board[0].length-1; j++){
        System.out.println(j);
        System.out.println(board[i][j]);
        if(board[i][j] == letters[0]){
          // found the first char. Now look around.
          char[][] visited = new char[board.length][board[0].length];
          for (int l = 0; l < board.length; l++) {
            visited[l] = board[l].clone();  // Clone each row (deep clone)
          }
          visited[i][j] = '#';
          checkExistence(board, visited, letters, i , j, 0);
        }
      }
    }

    return false;
  }

  private boolean checkExistence(char[][] board, char[][] visited, char[] letters,  int i, int j, int index) {
      if(index == letters.length){
        return true;
      }

      // do the check
    if( i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != letters[index]){
      return false;
    }

    visited[i][j] = '#';

    boolean found = checkExistence(board, visited, letters, i-1, j , index++) ||
        checkExistence(board, visited, letters, i+1, j , index++) ||
        checkExistence(board, visited, letters, i, j+1 , index++) ||
        checkExistence(board, visited, letters, i, j-1 , index++);

//    board[i][j] = '';

    return found;

  }
}
