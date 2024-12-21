package BasicsDSASheet.src.main.java.org.example.dp;
/*
# Algos
[Note]
[Reference]: https://www.youtube.com/watch?v=AxNNVECce8c; https://takeuforward.org/data-structure/maximum-sum-of-non-adjacent-elements-dp-5/
[Problem]: https://takeuforward.org/data-structure/maximum-sum-of-non-adjacent-elements-dp-5/
[Pattern]: DP Basic , Space optimization, with modification
[Tips]:
[Revision]: 0
[Confidence]: 10%
[Next]: Practice
[Steps]:
[Code]
Pick non pick problem.
[/Code]
[Tags]:
[/Note]
*/

public class MaximumSumOfNonAdjecentElements {

  private static int solveUtil(int ind, int[] arr, int[] dp){
    if(ind < 0 ) return 0;
    if(ind == 0) return arr[ind];

    if(dp[ind] != -1 ) return dp[ind];

    int pick = arr[ind] + solveUtil(ind -2 , arr, dp);
    int nonPick = solveUtil(ind-1, arr, dp);

    dp[ind] = Math.max(pick , nonPick);
    return dp[ind];
  }
}
