package BasicsDSASheet.src.main.java.org.example.dp;
/*
# Algos
[Note]
[Reference]: https://takeuforward.org/data-structure/dynamic-programming-frog-jump-dp-3/
[Problem]: https://takeuforward.org/data-structure/dynamic-programming-frog-jump-dp-3/
[Pattern]: DP Basic , Space optimization, with modification
[Tips]:
[Revision]: 0
[Confidence]: 10%
[Next]: Practice
[Steps]:
[Code]
Basic recurdion,
just that i need to tc of finding height so i need height[] to be passed around.
also height array is needed to find energy so it's height[i] - height[i-1]
also as an second option it can be height[i] - height[i-1]
since i-2 for jump 2 will be invalid when index is 0 since it will become -1, so i have a check stating i > 1.
Also since once the jumpTwo will not be present and at end i am doing math.min so i will assigh jumpTwo as Integer.MAX_VALUE.
[/Code]
[Tags]:
[/Note]
*/
import java.util.Arrays;

public class JumpingFrog {
  private static int solve(int index, int[] height, int[] dp){
    if(index == 0) return 0;
    if(dp[index] != -1) return dp[index];

    int jumpTwo = Integer.MAX_VALUE;
    int jumpOne = solve(index-1, height, dp) + Math.abs(height[index] - height[index-1]);
    if(index > 1){
      jumpTwo = solve(index-1, height, dp) + Math.abs(height[index] - height[index-2]);
    }

    dp[index] = Math.min(jumpOne, jumpTwo);
    return dp[index];
  }

  private static int solveTabulation(int index, int[] height, int[] dp){
    dp[0] = 0; // I am just using simple 1D array for tabulation.
    for(int i = 1; i < height.length; i++){
      int jumpTwo = Integer.MAX_VALUE;
      int jumpOne = dp[i-1] + Math.abs(height[i] - height[i-1]);
      if(i > 1){
        jumpTwo = dp[i-2] + Math.abs(height[i] - height[i-2]);
      }
      dp[i] = Math.min(jumpOne, jumpTwo);
    }
    return dp[height.length-1];
  }


  private static int solveTabulationWithLessSpace(int index, int[] height){
    int prev1 = 0;
    int prev2 = 0;
    for(int i = 1; i < height.length; i++){
      int jumpTwo = Integer.MAX_VALUE;
      int jumpOne = prev1 + Math.abs(height[i] - height[i-1]);
      if(i > 1){
        jumpTwo = prev2 + Math.abs(height[i] - height[i-2]);
      }
      int curr = Math.min(jumpOne, jumpTwo);
      prev2 = prev1;
      prev1 = curr;
    }
    return prev1;
  }
  public static void main(String[] args) {
    int[] height = {30,10,60,10,60,50};
    int n = height.length;
    int[] dp = new int[n];
    Arrays.fill(dp,-1);

    System.out.println(solve(n-1, height, dp));
  }
}
