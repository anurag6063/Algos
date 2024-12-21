package BasicsDSASheet.src.main.java.org.example.dp;
/*
# Algos
[Note]
[Reference]: https://takeuforward.org/data-structure/dynamic-programming-frog-jump-with-k-distances-dp-4/
[Problem]: https://takeuforward.org/data-structure/dynamic-programming-frog-jump-with-k-distances-dp-4/
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
it's similar to previous question, just that now the branching factor in K.
so rather than doing jumpOne & jumpTwo.
i need to for loop it.
also once the ans is dound keep it in tempVariable to find the final minimum.
[/Code]
[Tags]:
[/Note]
*/
import java.util.Arrays;

public class JumpingFrogKSteps {

  private static int solve(int n, int[] height, int k){
    int[] dp = new int[n];
    Arrays.fill(dp, -1);
    return solveUtils(n-1, height, dp, k);
  }

  private static int solveUtils(int n, int[] height, int[] dp, int k){
    if(n == 0) return 0;
    if(dp[n] != -1) return dp[n];

    int mmSteps = Integer.MAX_VALUE;
    for(int i = 1; i <=k; i++){
      if(n - i >= 0){
        int jump = solveUtils(n - i, height, dp, k) + Math.abs(height[n] - height[n-i]);
        mmSteps = Math.min(mmSteps, jump);
      }
    }
    dp[n] = mmSteps;
    return dp[n];
  }

  private static int solveUtilsTabulation(int n, int[] height, int[] dp, int k){
    dp[0] = 0;

    for(int j =1 ; j < n ; j++) {
        int mmSteps = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
          if (n - i >= 0) {
            int jump = dp[n-1] + Math.abs(height[n] - height[n - i]);
            mmSteps = Math.min(mmSteps, jump);
          }
        }
        dp[j] = mmSteps;
    }
    return dp[n-1];
  }

  public static void main(String[] args) {
    int[] height = {30,10,60,10,60,50};
    int n = height.length;
    int k = 2;
    solve(n, height, k);
  }
}
